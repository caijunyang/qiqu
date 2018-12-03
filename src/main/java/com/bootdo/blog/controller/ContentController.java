package com.bootdo.blog.controller;

import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.bootdo.blog.domain.Discover;
import com.bootdo.blog.service.ContentService;
import com.bootdo.blog.util.FileUtil;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 文章内容
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2017-09-09 10:03:34
 */
@Controller
@RequestMapping("/blog/bContent")
public class ContentController{
	@Autowired
    ContentService bContentService;
	
	@Value("${bootdo.imageUrl}")
	private String imageUrl;
	
	private final ResourceLoader resourceLoader;  

	@Autowired  
    public ContentController(ResourceLoader resourceLoader) {  
        this.resourceLoader = resourceLoader;  
    }  
 
	@GetMapping()
	@RequiresPermissions("blog:bContent:bContent")
	String bContent() {
		return "blog/bContent/bContent";
	}

	@ResponseBody
	@GetMapping("/list")
	public PageUtils list(@RequestParam Map<String, Object> params) {
		Query query = new Query(params);
		List<Discover> bContentList = bContentService.list(query);
		for (Discover discover : bContentList) {
			if(discover.getDiscoverType().equals("0")){
				discover.setDiscoverType("轮播图");
			}else{
				discover.setDiscoverType("单图");
			}
		}
		int total = bContentService.count(query);
		PageUtils pageUtils = new PageUtils(bContentList, total);
		return pageUtils;
	}

	@GetMapping("/add")
	String add() {
		return "blog/bContent/add";
	}
	
	@GetMapping("/open/post/{cid}")
	String post(@PathVariable("cid") String cid, Model model) {
		Discover discover = bContentService.get(cid);
		model.addAttribute("title", discover.getDiscoverTitle());
		model.addAttribute("message", discover.getDiscoverMessage());
		return "blog/bContent/message";
	}
	
	@GetMapping("/edit/{discoverId}")
	String edit(@PathVariable("discoverId") String discoverId, Model model) {
		Discover bDiscover = bContentService.get(discoverId);
		model.addAttribute("bContent", bDiscover);
		return "blog/bContent/edit";
	}

	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")//@RequestParam("file") MultipartHttpServletRequest fi
	public R save(Discover bContent,@RequestParam("file") MultipartFile file,HttpServletRequest request) {
		String path = request.getSession().getServletContext().getRealPath("src/main/resources/static/file/image/");
		if(file !=null){
			String fileName = file.getOriginalFilename();
			fileName = FileUtil.renameToUUID(fileName).replace("-", "");
			try {
				FileUtil.uploadFile(file.getBytes(), path, fileName);
			} catch (Exception e) {
				e.printStackTrace();
			}
			bContent.setDiscoverImageUrl(imageUrl+fileName);
		}
		bContent.setDiscoverEndTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		int count; 
		if (bContent.getDiscoverId() == null || "".equals(bContent.getDiscoverId())) {
			bContent.setDiscoverId(UUID.randomUUID().toString().replace("-", ""));
			bContent.setDiscoverType(bContent.getDiscoverType());
			count = bContentService.save(bContent);
		} else {
			bContent.setDiscoverType(bContent.getDiscoverType());
			bContent.setDiscoverImageUrl(bContent.getDiscoverImageUrl());
			count = bContentService.update(bContent);
		}
		if (count > 0) {
			return R.ok().put("discoverId", bContent.getDiscoverId());//
		}
		return R.error();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "image/{filename:.+}")
	@ResponseBody
	public ResponseEntity<?> getFile(@PathVariable String filename,HttpServletRequest request) {
		String path = request.getSession().getServletContext().getRealPath("src/main/resources/static/file/image/");
		System.err.println(path);
		try {
			return ResponseEntity.ok(resourceLoader.getResource("file:" + Paths.get(path, filename).toString()));
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}

	/**
	 * 修改
	 */
	@ResponseBody
	@PostMapping("/update")
	public R update( Discover bContent) {
		bContent.setDiscoverEndTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		Discover discover = bContentService.get(bContent.getDiscoverId());
		bContent.setDiscoverImageUrl(discover.getDiscoverImageUrl());
		bContentService.update(bContent);
		return R.ok();
	}

	/**
	 * 删除
	 */
	@PostMapping("/remove")
	@ResponseBody
	public R remove(String id) {
		if (bContentService.remove(id) > 0) {
			return R.ok();
		}
		return R.error();
	}

	/**
	 * 删除
	 */
	@PostMapping("/batchRemove")
	@ResponseBody
	public R remove(@RequestParam("ids[]") String[] cids) {
		bContentService.batchRemove(cids);
		return R.ok();
	}
}
