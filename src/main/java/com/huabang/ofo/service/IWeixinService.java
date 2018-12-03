package com.huabang.ofo.service;

import javax.servlet.http.HttpServletRequest;

public interface IWeixinService {

	
	String update_app_weixin_perpayInCharge(HttpServletRequest request) throws Exception;

	String updateWeixinPayCallBack(HttpServletRequest request) throws Exception;

	String app_qryWeixinPayStatus(HttpServletRequest request);

	String update_app_weixin_perpayInUpgrade(HttpServletRequest request) throws Exception;

	
}
