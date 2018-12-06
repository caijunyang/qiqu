package com.huabang.ofo.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.huabang.ofo.service.BikeService;

@Controller
@RequestMapping("/bike")
@ResponseBody
public class BikeController {

	@Autowired
	private BikeService bikeServiceImpl;
	
	/**
	 * 开始用车
	 * @param shareId
	 * @param telePhone
	 * @param lat
	 * @param lng
	 * @return
	 */
	@PostMapping("/start")
	@ResponseBody
	public JSONObject useBike(@RequestParam Map<String,String> map){
		String shareId = (String)map.get("shareId");
		String telePhone = (String)map.get("telephone");
		System.out.println(shareId+"++++++++++++"+telePhone);
		/*String lat = (String)map.get("lat");
		String lng = (String)map.get("lng");*/
		/*String pot = lat + lng;*/
		JSONObject result = this.bikeServiceImpl.useBike(shareId,telePhone);
		return result;
	}
	/**
	 * 结束用车
	 * @param shareId
	 * @param telePhone
	 * @param lat
	 * @param lng
	 * @return
	 */
	@PostMapping("/end")
	@ResponseBody
	public JSONObject endUseBike(@RequestParam Map<String,String> map){
		String shareId = (String)map.get("shareId");
		String lat = (String)map.get("lat");
		String lng = (String)map.get("lng");
		String pot = lat +","+ lng;
		JSONObject result = this.bikeServiceImpl.endUseBike(shareId,pot);
		return result;
	}
	
	/**
	 * 检查车辆是否在计费,返回计费开始时间
	 */
	@PostMapping("/userbike")
	@ResponseBody
	public JSONObject userBikelog(@RequestParam Map<String,String> map) {
		String telePhone=(String)map.get("telePhone");
		return this.bikeServiceImpl.getUseBike(telePhone);
	}
	
}
