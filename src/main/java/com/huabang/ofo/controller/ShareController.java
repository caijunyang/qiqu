package com.huabang.ofo.controller;

import java.nio.file.Paths;
import java.util.Map;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huabang.ofo.service.SharesService;

@Controller
@RequestMapping("/share")
public class ShareController {
	
	@Autowired
	private SharesService shareServiceImpl;
	private final ResourceLoader resourceLoader;  

	@Autowired  
    public ShareController(ResourceLoader resourceLoader) {  
        this.resourceLoader = resourceLoader;  
    }  
	
	/**
	 * 以自己为中心附近1公里内的单车
	 * @param lat
	 * @param lng
	 * @return
	 */
	@PostMapping("/list")
	@ResponseBody
	public String share(@RequestParam Map<String,String> map){
		String lat = (String)map.get("lat");
		String lng = (String)map.get("lng");
		String jsonShare = this.shareServiceImpl.selectShareAll(lat,lng);
		return jsonShare;
	}
	/**
	 * 查看图片
	 * @param filename
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/image/{filename:.+}")
	@ResponseBody
	public ResponseEntity<?> getFile(@PathVariable String filename, HttpServletRequest request) {
		String path = request.getSession().getServletContext().getRealPath("src/main/resources/static/file/image/");
		try {
			return ResponseEntity.ok(resourceLoader.getResource("file:" + Paths.get(path, filename).toString()));
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}

}
