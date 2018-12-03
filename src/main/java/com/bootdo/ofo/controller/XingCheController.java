package com.bootdo.ofo.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bootdo.common.domain.PageDO;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;
import com.bootdo.ofo.service.XingCheService;

@RequestMapping("/xingche") 
@Controller
public class XingCheController {
	@Autowired 
	private XingCheService xingCheService;
	String prefix = "ofo/xingche";

	@GetMapping()
	String orders() {
		return prefix + "/xingche";
	}

	@ResponseBody
	@GetMapping("/list")
	PageDO<Map<String, Object>> list(@RequestParam Map<String, Object> params) {
		Query query = new Query(params);
		PageDO<Map<String, Object>> page = xingCheService.queryList(query);
		return page;
	}
	
	@ResponseBody
	@PostMapping("/remove")
	R remove(String id) {
		if (xingCheService.remove(id)>0) {
			return R.ok();
		}
		return R.error();
	}

	@ResponseBody
	@PostMapping("/batchRemove")
	R batchRemove(@RequestParam("ids[]") String[] ids) {
		int r = xingCheService.batchRemove(ids);
		if (r > 0) {
			return R.ok();
		}
		return R.error();
	}
}
