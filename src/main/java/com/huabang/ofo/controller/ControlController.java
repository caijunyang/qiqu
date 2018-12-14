package com.huabang.ofo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.huabang.ofo.dao.HbOrdersMapper;
import com.huabang.ofo.domain.HbOrder;
import com.huabang.ofo.service.ControlService;

@Controller
@RequestMapping("/control")
@ResponseBody
public class ControlController {

	@Autowired
	private ControlService controlServiceImpl;
	@Autowired
	private HbOrdersMapper hbOrdersMapper;
	/**
	 * 都可以缴纳多少押金
	 * @return
	 */
	@PostMapping("/cash")
	public String cash(){
		String result = this.controlServiceImpl.selectCashAll();
		return result;
	}
	
	/**
	 * 都可以充值多少元
	 * @return
	 */
	@PostMapping("/pay")
	public String pay(){
		String result = this.controlServiceImpl.selectPayAll();
		return result;
	}
	
	/**
	 * 回掉
	 * @return
	 * @throws Exception 
	 */
	@PostMapping("/app_alipayCallBack")
	@ResponseBody
	public String app_alipayCallBack(HttpServletRequest request) throws Exception{
		String result = this.controlServiceImpl.huiDiao(request);
		return result;
	}
	
	/**
	 * 微信回调
	 * */
	@PostMapping("/app_weixpayCallBack")
	@ResponseBody
	public void app_weixpayCallBack(HttpServletRequest request, HttpServletResponse response) throws Exception{
		this.controlServiceImpl.weixhuiDiao(request,response);
	}
	
	/**
	 * 固定金额轮询状态
	 * */
	@PostMapping("/order_status")
	@ResponseBody
	public JSONObject order_status(HttpServletRequest request, HttpServletResponse response) throws Exception{
		JSONObject JSONObject=new JSONObject();
		String orderid = request.getParameter("orderid");
		HbOrder order = this.hbOrdersMapper.selectByPrimaryKey(orderid);
		if(order==null || order.getOrderStatus()==null){
			JSONObject.put("code", "400");
		}else{
			JSONObject.put("code", "200");
		}
		return JSONObject;
	}
	
}
