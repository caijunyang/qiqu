package com.refund;

import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSONObject;
import com.huabang.ofo.dao.HbUserCashsMapper;
import com.huabang.ofo.domain.HbUserCash;
import com.tenpay.util.UUID;

public class impl {
	public JSONObject refund(HttpServletRequest request,HbUserCash userCash,HbUserCashsMapper hbUserCashMapper){
		JSONObject JSONObject=new JSONObject();
		SortedMap<String, String> packageParams = new TreeMap<String, String>();
		 packageParams.put("appid", "wx1ebc0edb8656a12e");//应用id
		 packageParams.put("mch_id", "1517726061");//商户号
		 packageParams.put("nonce_str",UUID.next()+"");//随机字符串
		 packageParams.put("out_refund_no", UUID.next()+"");//退款单号
		 
		 //packageParams.put("out_trade_no",userCash.getOrderidWeix());//订单号
		 packageParams.put("out_trade_no",userCash.getOrderidWeix());
		 //packageParams.put("total_fee",userCash.getUserCash().toString());//订单总金额Utils.getMoney()
		 Double userCash2 = userCash.getUserCash()*100;
		 packageParams.put("total_fee",(userCash2).intValue()+"");
		 //packageParams.put("refund_fee",userCash.getUserCash().toString());//退款总金额
		 packageParams.put("refund_fee",(userCash2).intValue()+"");
		 packageParams.put("op_user_id", "1517726061");//商户号
		 
		 String sign = Utils.signMd5_2(packageParams, "dfsfdvdfvgk32423423oGdfsfdsvBO67");
		 String result = "FAIL";
		 String msg = "";
	// logger.debug("--sign--="+sign);
		 System.out.println("--sign--="+sign);

		 String createOrderURL = "https://api.mch.weixin.qq.com/secapi/pay/refund";
		 String xml = null;
		try {
		 xml = Utils.createXML(packageParams,sign.toUpperCase());
		 } catch (UnsupportedEncodingException e) {
			 e.printStackTrace();
		}
		//logger.debug("--xml-="+xml);
		System.out.println("--xml-="+xml);
		String retur=null;
		try {
		 retur = ClientCustomSSL.doRefund(createOrderURL, xml);

		 System.out.print(retur);
		 } catch (Exception e) {
		 e.printStackTrace();
		}
		 if (!StringUtils.isEmpty(retur)) {
		Map map = JSONUtil.parseXmlToMap(retur);

		 String returnCode = (String) map.get("return_code");
		 if(returnCode.equals("SUCCESS")){
			 result = "SUCCESS";
			 String resultCode = (String)map.get("result_code");
			 if(resultCode.equals("SUCCESS")){
				 String outtradeno = (String) map.get("out_trade_no"); // 订单号
				 hbUserCashMapper.returnCash(outtradeno);
				 JSONObject.put("code", "200");
				 JSONObject.put("msg", "ok");
			 }else{
				 msg = (String)map.get("return_msg");
				 JSONObject.put("code", "400");
				 JSONObject.put("msg", " 微信退款失败 refundfail msg="+msg);
			 }
		 }
		 if (result.equals("FAIL")) {
			 msg = (String)map.get("return_msg");
			 System.out.println(" 微信退款失败 refundfail msg="+msg);
			 JSONObject.put("code", "400");
			 JSONObject.put("msg", " 微信退款失败 refundfail msg="+msg);
			//logger.info(" 微信退款失败 refundfail msg="+msg);
		 }


		 }
		return JSONObject;
	}
}
