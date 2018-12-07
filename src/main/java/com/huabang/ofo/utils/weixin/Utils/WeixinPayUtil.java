package com.huabang.ofo.utils.weixin.Utils;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang.RandomStringUtils;
import com.alibaba.fastjson.JSONObject;
import com.huabang.ofo.domain.HbOrder;
import com.huabang.ofo.domain.HbUser;
import com.huabang.ofo.domain.HbUserCash;
import com.huabang.ofo.service.UsersService;
import com.tenpay.PrepayIdRequestHandler;
import com.tenpay.util.ConstantUtil;
import com.tenpay.util.MD5Util;
import com.tenpay.util.UUID;
import com.tenpay.util.WXUtil;


 
/**
 * 微信支付测试
 */
public class WeixinPayUtil {
	private UsersService userServiceImpl;
	 private String out_trade_no = "";
	public WeixinPayUtil(UsersService userServiceImpl) {
		this.userServiceImpl = userServiceImpl;
	}
	public JSONObject pay(HttpServletRequest request, HttpServletResponse response) {
		JSONObject object = new JSONObject();
		HashMap<String,Object> mymap=new HashMap<>();
        Map<String, Object> map = new HashMap<String, Object>();
        // 获取生成预支付订单的请求类
        PrepayIdRequestHandler prepayReqHandler = new PrepayIdRequestHandler(request, response);
        String totalFee =request.getAttribute("totalMoney").toString();
        int total_fee=(int) (Float.valueOf(totalFee)*100);//金额单位默认是分
        prepayReqHandler.setParameter("appid", ConstantUtil.APP_ID);
        prepayReqHandler.setParameter("body", ConstantUtil.BODY);
        prepayReqHandler.setParameter("mch_id", ConstantUtil.MCH_ID);
        String nonce_str = WXUtil.getNonceStr();
        prepayReqHandler.setParameter("nonce_str", nonce_str);
        prepayReqHandler.setParameter("notify_url", ConstantUtil.NOTIFY_URL);
        out_trade_no = String.valueOf(UUID.next());
        prepayReqHandler.setParameter("out_trade_no", out_trade_no);
        prepayReqHandler.setParameter("spbill_create_ip", request.getRemoteAddr());
        String timestamp = WXUtil.getTimeStamp();
        prepayReqHandler.setParameter("time_start", timestamp);
        System.out.println(String.valueOf(total_fee));
        prepayReqHandler.setParameter("total_fee", String.valueOf(total_fee));
        prepayReqHandler.setParameter("trade_type", request.getAttribute("trade_type"));
        prepayReqHandler.setParameter("sign", prepayReqHandler.createMD5Sign());
	    prepayReqHandler.setGateUrl(ConstantUtil.GATEURL);
        /**
         * 注意签名（sign）的生成方式，具体见官方文档（传参都要参与生成签名，且参数名按照字典序排序，最后接上APP_KEY,转化成大写）
         */
        
        try {
			HbUser user = this.userServiceImpl.selectUserObject(String.valueOf(request.getAttribute("telephone")));
			String numeric = System.currentTimeMillis() + RandomStringUtils.randomNumeric(6);
			String type = String.valueOf(request.getAttribute("type"));
			HbOrder order = new HbOrder();
			if (type.equals("0")) { // 押金
				HbUserCash cash = new HbUserCash();
				cash.setUserId(user.getUserId());
				cash.setUserAccountMoney(String.valueOf(request.getAttribute("money")));
				cash.setUserCash(Double.parseDouble(String.valueOf(request.getAttribute("cashMoney"))));
				cash.setUserCashType(Integer.parseInt(String.valueOf(request.getAttribute("cashType"))));
				cash.setUserCashStatus(2);
				cash.setOrderidWeix(out_trade_no);
				//保存押金信息
				this.userServiceImpl.saveUserCash(cash);
				order.setOrderType(0);
				order.setOrderCashId(user.getUserId());
			}else{//充值
				order.setOrderType(1);
				order.setOrderCashId(null);
			}
			order.setOrderId(out_trade_no);
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			order.setOrderCreatetime(format.parse(format.format(new Date())));
			order.setOrderPrice(Double.parseDouble(String.valueOf(request.getAttribute("totalMoney"))));
			order.setOrderUserid(user.getUserId());
			this.userServiceImpl.saveOrder(order);
			
		        String prepayid = prepayReqHandler.sendPrepay();
		        // 若获取prepayid成功，将相关信息返回客户端
		        if (prepayid != null && !prepayid.equals("")) {
		            String signs = "appid=" + ConstantUtil.APP_ID + "&noncestr=" + nonce_str + "&package=Sign=WXPay&partnerid="
		                    + ConstantUtil.PARTNER_ID + "&prepayid=" + prepayid + "&timestamp=" + timestamp + "&key="
		                    + ConstantUtil.APP_KEY;
		            map.put("code", 0);
		            map.put("info", "success");
		            map.put("prepayid", prepayid);
		            /**
		             * 签名方式与上面类似
		             */
		            map.put("sign", MD5Util.MD5Encode(signs, "utf8").toUpperCase());
		            map.put("appid", ConstantUtil.APP_ID);
		            map.put("timestamp", timestamp);  //等于请求prepayId时的time_start
		            map.put("noncestr", nonce_str);   //与请求prepayId时值一致
		            map.put("package", "Sign=WXPay");  //固定常量
		            map.put("partnerid", ConstantUtil.PARTNER_ID);
		            
		            mymap.put("sdk",map);
					object.put("data", mymap);
		            object.put("code", "200");
		        	object.put("msg", "获取签名成功");
		        } else {
		        	object.put("code", "400");
		        	object.put("msg", "获取签名失败");
		        }
		} catch (Exception e) {
			e.printStackTrace();
			object.put("code", "400");
	    	object.put("msg", "获取签名失败");
		}
        return object;
	}
}
