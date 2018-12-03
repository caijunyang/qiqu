/*package com.huabang.ofo.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.huabang.ofo.service.IWeixinService;
import com.huabang.ofo.utils.weixin.Utils.WeixinPayUtil;
import com.huabang.ofo.utils.weixin.entity.Weiwinreturn;


@Service("weixinService")
public class WeixinServiceImpl implements IWeixinService {

	*//**
	 * 充值_微信统一下单(预支付)
	 * @param request
	 * @return
	 * @throws DocumentException
	 *//*
	@Override
	public String update_app_weixin_perpayInCharge(HttpServletRequest request) throws Exception {
		//String vipId=request.getParameter("vipId");
		//String total_fee=request.getParameter("total_fee"); // app传来的金额，单位分
		//String body=request.getParameter("body");  	
		//String osType=request.getParameter("osType");
		//openid total_fell:多少钱  body:商品说明
		//传过来的信息
		String out_trade_no=System.currentTimeMillis()+"";
		
		Weiwinreturn rMap=new Weiwinreturn();
		rMap=(Weiwinreturn) WeixinPayUtil.perpay(request,out_trade_no);
		String object=rMap.getCode();
		if("1".equals(object)){
			Map content=(Map) rMap.getContent();
			String prepay_id=(String) content.get("prepayid");
			System.out.println("支付成功");
		}
		List<Weiwinreturn> list=new ArrayList<Weiwinreturn>();
		list.add(rMap);
		JSONObject jsonobject = new JSONObject();
		jsonobject.put("list", list);
		return jsonobject.toString();
	}

	
	*//**
	 * 微信回调
	 * @param request
	 * @return
	 * @throws Exception 
	 *//*
	@Override
	public String updateWeixinPayCallBack(HttpServletRequest request) throws Exception {
		
		SAXReader sr=new SAXReader();
        Document doc= sr.read(request.getInputStream());
    	Element rootElt = doc.getRootElement(); // 获取根节点 
		String return_code=rootElt.elementTextTrim("return_code");
		System.out.println("微信回调返回"+return_code+"=======================================");
		
		StringBuilder xmlStr= new StringBuilder("<xml>");
		if(return_code.equalsIgnoreCase("SUCCESS")){
			//更新充值表
			xmlStr.append("<return_code>");
			xmlStr.append("SUCCESS");
			xmlStr.append("</return_code>");
			xmlStr.append("<return_msg>");
			xmlStr.append("OK");
			xmlStr.append("</return_msg>");
			xmlStr.append("</xml>");
			
			String out_trade_no=rootElt.elementTextTrim("out_trade_no");  //订单号
			String result_code=rootElt.elementTextTrim("result_code");    //业务结果
			String time_end=rootElt.elementTextTrim("time_end");         // 支付完成时间
			String gmt_payment="";
			System.out.println("订单号："+out_trade_no+",订单情况:"+result_code);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
			try {
				Date date=sdf.parse(time_end);
				sdf.applyPattern("yyyy-MM-dd HH:mm:ss");
				gmt_payment=sdf.format(date);
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
		}else{
				xmlStr.append("<return_code>");
				xmlStr.append("FAIL");
				xmlStr.append("</return_code>");
				xmlStr.append("<return_msg>");
				xmlStr.append("return_code is not SUCCESS");
				xmlStr.append("</return_msg>");
				xmlStr.append("</xml>");
			}
		System.out.println(xmlStr.toString());
		return xmlStr.toString();
		
	}
	
	*//**
	 * 微信查询充值状态(结果)
	 * @param request
	 * @return
	 * @throws Exception 
	 *//*
	@Override
	public String app_qryWeixinPayStatus(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String update_app_weixin_perpayInUpgrade(HttpServletRequest request) throws Exception {
		
		return null;
	}



}
*/