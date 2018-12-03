package com.huabang.ofo.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ControlService {
	/**
	 * 都可以缴纳多少押金
	 * @return
	 */
	String selectCashAll();
	/**
	 * 都可以充值多少元
	 * @return
	 */
	String selectPayAll();
	/**
	 * 支付宝的回调函数
	 * @param request
	 * @return
	 * @throws Exception 
	 */
	String huiDiao(HttpServletRequest request) throws Exception;
	/**
	 * 微信的回调函数
	 * @param request
	 * @return
	 * @throws Exception 
	 */
	void weixhuiDiao(HttpServletRequest request, HttpServletResponse response)throws Exception;

}
