package com.huabang.ofo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.huabang.ofo.domain.Discover;
import com.huabang.ofo.service.ContentsService;
import com.huabang.ofo.service.MessagesService;

@Controller
@RequestMapping("/message")
public class MessageController {

	@Autowired
	private MessagesService MessageServiceImpl;
	@Autowired
	private ContentsService contentService;
	
	/**
	 * 消息的详细信息
	 * @return
	 */
	@PostMapping("/message")
	@ResponseBody
	public String message(@RequestParam Map<String,String> map){
		String messageId = (String)map.get("messageId");
		String message = this.MessageServiceImpl.selectAllMessage(messageId);
		return message;
	}
	/**
	 * 消息的简略信息展示
	 * @return
	 */
//	@GetMapping("/detailMessage")
	@PostMapping("/detailMessage")
	@ResponseBody
	public String simmpleMessage(){
		String simmpleMessage = this.MessageServiceImpl.selectSimmpleMessage();
		System.err.println(simmpleMessage);
		return simmpleMessage;
	}

	/**
	 * 发现的简略信息展示
	 * @return
	 */
	@PostMapping("/find")
	@ResponseBody
	public JSONObject selectAll(){
		JSONObject object = new JSONObject();
		List<Discover> simmpleMessage = this.contentService.list();//0轮播图
		List<Discover> list2 = this.contentService.list2();//1单图
		HashMap<String,Object> map=new HashMap<String,Object>();
		map.put("img_rotate", simmpleMessage);
		map.put("img_single", list2);
		object.put("data", map);
		object.put("code","200");
		return object;
	}
	
	/**
	 * 详细信息
	 * @param cid
	 * @param model
	 * @return
	 */
	@GetMapping("/open/post/{cid}")
	String post(@PathVariable("cid") String cid, Model model) {
		Discover discover = contentService.get(cid);
		model.addAttribute("title", discover.getDiscoverTitle());
		model.addAttribute("message", discover.getDiscoverMessage());
		return "message";
	}
}
