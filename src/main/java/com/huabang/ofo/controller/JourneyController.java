package com.huabang.ofo.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huabang.ofo.service.JourneyService;

@Controller
@RequestMapping("/journey")
public class JourneyController {

	@Autowired
	private JourneyService journeyServiceImpl;
	
	/**
	 * 我的行程
	 * @param phone
	 * @param code
	 * @return
	 */
	@PostMapping(value="/")
	@ResponseBody
	public String journey(@RequestParam Map<String,String> map){
		String phone = (String)map.get("phone");
		String Journey = this.journeyServiceImpl.selectJourney(phone);
		return Journey;
	}
	/**
	 * 行程详细信息 
	 * @param journeyId
	 * @return
	 */
	@PostMapping("/detail")
	@ResponseBody
	public String detailJourney(@RequestParam Map<String,String> map){
		String journeyId = (String)map.get("journeyId");
		String Journey = this.journeyServiceImpl.selectById(journeyId);
		return Journey;
	}
}
