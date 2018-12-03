package com.bootdo.ofo.controller;

import java.nio.file.Paths;
import java.util.List;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.bootdo.common.utils.FileUtil;
import com.bootdo.ofo.domain.HbShare;
import com.bootdo.ofo.service.ShareService;


@RequestMapping("share")
@Controller
public class SharController {
	
	//静态资源根目录
	private String prefix="ofo/share/";
	@Autowired
	private ShareService shareService;
	
	private final ResourceLoader resourceLoader;  
  
    @Autowired  
    public SharController(ResourceLoader resourceLoader) {  
        this.resourceLoader = resourceLoader;  
    }  
	/**
	* @Function: ShareController.java
	* @Description: 跳转到分享点管理页面
	* @version: v1.0.0
	* @author: 郝培荣
	*
	 */
	@RequestMapping(method=RequestMethod.GET)
	@RequiresPermissions("share:share")
	public String toSharePage(){
		return prefix+"share";
	}
	/**
	 * 
	* @Function: ShareController.java
	* @Description: 跳转到增加分享点页面
	* @version: v1.0.0
	* @author: 郝培荣
	 */
	@RequestMapping(value="/addShare",method=RequestMethod.GET)
	public String toAdd(){
		return prefix+"share/add";
	}
	
	/**
	 * 
	* @Function: ShareController.java
	* @Description: 前往详细信息页面
	 */
	@RequestMapping(value="/toDetailPage",method=RequestMethod.GET)
	public String toDetailPage(){
		return prefix+"share/detail";
	}
	/**
	 * 
	* @Function: ShareController.java
	* @Description: 车辆管理
	 */
	@RequestMapping(value="/manage",method=RequestMethod.GET)
	public String manage(){
		return prefix+"share2";
	}
	/**
	 * 
	* @Function: ShareController.java
	* @Description: 上传分享点图片文件
	 */
	@ResponseBody
	@PostMapping("/upload")
	public String upload(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
		String path = request.getSession().getServletContext().getRealPath("src/main/resources/static/file/image/");
		String fileName = file.getOriginalFilename();
		fileName = FileUtil.renameToUUID(fileName).replace("-", "");
		try {
			FileUtil.uploadFile(file.getBytes(), path, fileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		JSONObject jsonObject=new JSONObject();
		jsonObject.put("msg", fileName);
		return jsonObject.toJSONString();
	}
	/**
	 * 
	* @Function: ShareController.java
	* @Description: 新增分享点
	 */
	@ResponseBody
	@PostMapping("/addShareInfo")
	public Boolean addShareInfo(HbShare hbShare){
		return shareService.addQiXinShare(hbShare);
	}
	/**
	 * 
	* @Function: ShareController.java
	* @Description: 查询分享点分布
	 */
	@ResponseBody
	@PostMapping("/searchShareMapInfo")
	public List<HbShare> searchShareMapInfo(Integer start,Integer pagesize){
		return shareService.searchShareMapDo(start,pagesize);
	}
	
	/**
	 * 
	* @Function: ShareController.java
	* @Description: 更新分享点信息
	 */
	@ResponseBody
	@PostMapping("/updateShareById")
	public Boolean updateShareById(HbShare hbShare){
		return shareService.updateShareById(hbShare);
	}
	/**
	 * 
	 * @Function: ShareController.java
	 * @Description: 删除分享点信息
	 */
	@ResponseBody
	@PostMapping("/deleteShareById")
	public Boolean deleteShareById(HbShare hbShare){
		return shareService.deleteShareById(hbShare);
	}
	

	/**
	 * 	//显示图片的方法关键 匹配路径像 http://localhost/share/image/bc7c5a29385049c0a91912cb48f60951.jpg 
	* Copyright: Copyright (c) 2018 LanRu-Caifu
	* @return 
	* @ClassName: ShareController.java
	* @version: v1.0.0
	* @author: 郝培荣
	 */
    @RequestMapping(method = RequestMethod.GET, value = "/image/{filename:.+}")  
    @ResponseBody  
    public ResponseEntity<?> getFile(@PathVariable String filename,HttpServletRequest request) {  
    	String path = request.getSession().getServletContext().getRealPath("src/main/resources/static/file/image/");
        try {  
            return ResponseEntity.ok(resourceLoader.getResource("file:" + Paths.get(path, filename).toString()));  
        } catch (Exception e) {  
            return ResponseEntity.notFound().build();  
        }  
    }  
}
