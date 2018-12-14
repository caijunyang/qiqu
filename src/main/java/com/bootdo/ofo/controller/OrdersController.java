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
import com.bootdo.ofo.service.OrdersService;

@RequestMapping("/order") 
@Controller
public class OrdersController {
	@Autowired 
	private OrdersService ordersService;
	String prefix = "ofo/orders";

	@GetMapping()
	String orders() {
		return prefix + "/orders";
	}

	@ResponseBody
	@GetMapping("/list")
	PageDO<Map<String, Object>> list(@RequestParam Map<String, Object> params) {
		if(params.get("orderType")!=null || !"".equals(params.get("orderType"))){
			String type = (String) params.get("orderType");
			if(type.equals("押金")){
				params.put("orderType", "0");
			}else if(type.equals("充值")){
				params.put("orderType", "1");
			}else if(type.equals("退款")){
				params.put("orderType", "2");
			}else if(type.equals("消费")){
				params.put("orderType", "3");
			}
		}
		Query query = new Query(params);
		PageDO<Map<String, Object>> page = ordersService.queryList(query);
		return page;
	}
	
	@ResponseBody
	@PostMapping("/remove")
	R remove(String id) {
		if (ordersService.remove(id)>0) {
			return R.ok();
		}
		return R.error();
	}

	@ResponseBody
	@PostMapping("/batchRemove")
	R batchRemove(@RequestParam("ids[]") String[] ids) {
		int r = ordersService.batchRemove(ids);
		if (r > 0) {
			return R.ok();
		}
		return R.error();
	}
}
