package com.huabang.ofo.utils.alipay.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.RandomStringUtils;

import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeAppPayModel;
import com.alipay.api.request.AlipayTradeAppPayRequest;
import com.alipay.api.response.AlipayTradeAppPayResponse;
import com.huabang.ofo.domain.HbOrder;
import com.huabang.ofo.domain.HbUser;
import com.huabang.ofo.domain.HbUserCash;
import com.huabang.ofo.service.UsersService;

public class AliPayUtil {
	// public static String URL = "https://openapi.alipaydev.com/gateway.do";
	// //支付网关测试环境
	public static String URL = "https://openapi.alipay.com/gateway.do"; // 支付网关正式环境
//	public static String APP_ID = "2016091700529037"; // 测试appid
	 public static String APP_ID = "2018081060936681"; //正式appid
//	 public static String APP_ID = "2018081161017105"; //正式appid(开放平台)
//	public static String SellerId = "2088102175973234"; // 测试收款放账户
	 public static String SellerId = "2088622685803073"; //正式收款放账户
	// 商户的私钥
	// 测试
	public static String APP_PRIVATE_KEY = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCsZb7rq/mQWOyQVS1JG5ATmWApfO/qi7HWUvT0Su3TwoK+9vJ1xLU2Z79bxwcl6sj2IbEvLupRWVvj5WoMv6barOQ/bf2eKGUJlBPLtwzuwqtHjZuDRf6PLI873vM0ffOSFugAmd8sZCiozKAydJTtDWZc6saQjSHgpWFKgJQR6VziddEvBfEY9cBgqs5ugJTDnB9Mzb4VlRrfABK0JpMgDFi293ZLhFg0bfz8XJpkB/VESkXnpieDA3fk8Df1uXhb0K2zFriT18E6MuJbsU80yKK4LHipOjwVyiivp9yeh1CpW29lwXWi98aWkO/F0pflJhsKZMjYdzQ6Be0x/xO7AgMBAAECggEAXj8xZL2braIvkag/HZyH428R9xxqPJsqGbU4XOUpp37K44M1gdSMDLYjExV3fu8f9g7tQpIvX1GuvqQImfecTCgAj/ydjf0fX2EogVINK+oYoQF1Zwq446TEmUKFSskgg1kqdEmqjCYlZEKZwXuifwW4VEu1Sgkd4CYJTiWEzVURZo7Kmychsqyn3cTPEuwxT4xW/kglNbkhndEtYnluSXGEYSh/t4j45lsALOMG1VeucIXG4R7UEnmgHdGbZuFOAu70qiaeD8V8s+ziHsLdEPq+F3O/ZCwuEKhXOV/GJPnPQGa7MHMMu+GRcOfTwxhcsIha5CuBbzq7sT+LhyL0gQKBgQD5og+YG6vI2mtpSlmlFP1jhiamJ4cAUlh8ol4A9+7PFgr9RCXhgJAROeztSjnZllS1rX6S+/sEVYqbANnOgxb+9yQLA4+gKJOQdbkC0CypOHlnAVTZlCk2eO64+ko0R7iD8GWOh4IZWnSo+HJ9sCRsvrmdrrVsM/siizkfc1L0iwKBgQCwy2MoDlaMx4Ml8GnvavsPM7Nyfv+MtEz/7yibEcTsANxcQhxB0mivPy9b1h/7l4zAWFDrUZrPI+KmtJLYSAs+6jKnl/trJNiUZAhOackZ4fWNf1MoIPWRdBywCDNjxJZ3BVfitARyU6u/mNnYsrtnMT+fIxsobx9qzGpWK9zTkQKBgBDnjpLIXOuvDtMEe+mX8EjLDtb1mkjFSsS14hPCtmNDpN7dvIr2v8rK12aCPkSjz3y2EPo3Ihp7CHXSqu03J1mAtuogBZvc45FGx46PNlcHQgFdr7dENz4/Fjtkh53etXoJz3bFamP5IilHGcm1IeJTUBKDgDmhk4IVV3rvvlBdAoGBAIdXvJn+l/2AAwN5T+/sSzRxFPATDxmtMcFAWiqUaNdvNUMfjThKlr+KNHwuqR9W/naFZbUwLL5kr2+Fj2EpjgplCdBJRjzY4UCAb+dvjndVB0GCdquix7vJUujj7ktzROjq20P/IeRP74xmvGbrNRIjnpv6KSFEKJ3+zW0YeR4xAoGAD1lu/HiULTEh28R54jaX5SeuUGR9qbnlOy2Ngl/TZgxOdHrueQcgDrUd8bCY1LXhzp/psUbHtXYJEwTF9Pay37iNZzvYj80BitVL+IAx497+kjSfgyhfNDy7xMUaK8Vid6Sj2SVMSJV1N0GzBEGFNMIewY6BlMHNgrczd/dniOU=";
//	public static String APP_PRIVATE_KEY = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCRJBbn4ksgoadSBOOT7BQEx2Y6pGama+zeEMBjoOhll8hpKpDafKV3d6MZh+zR+5FJkZrgfarGERXqhVHO43i2Gfqr/QAKKvWoa7eiRHBQwOHC/t2lMnne8Sow1x9Hl8lQeb17+6LIHaSsEYWq78cXL3fNhH3XCx2aBkjM6jCN8LqmYHtio05KdhYGN+hXjlEugZdhgot31D0uCeCAdRZv4xY3MnoALW4fk5lGw99wIN/yXCTdBdHSaW1nn4+X03Y9aq4WBzjUiX+k6DqvQ+Q2kdXWgrM/EXwPjte9qAlphwgvPlO1mTrPFrYmG7c0M8eQuXI9fHRTCelvODBX6wvTAgMBAAECggEAVRofICnsuR5v+ESLmCFVf5PXWk0pLy2a/n4+AGzJtz/vL9LYinOJpeoNRRwQ/PKPtt5cPIMSzf4YpqEzXaa9EbFb7Np02oFj9zPpwYh1frQJ7Ab6uTFGijVH8slAOv9B+CDZvMfII6RV+NpxUNA1IWAg0+16x8tpuPU0XIp4m9CGgdEQQRB7mTZ7jnHdr0WqPJq8E9/Rcb+Pi4i7f5LnegLa60pHeuv6Dm+3uldwMDILeUHqyeknApjL8s2n5eEHC9rjnt0p/E25pzQdDU6V6LsfncKUPvqhyCnY/0e1N57j9NWIp6Yw0xAJEd4hhChVVjWA1mxCfcIDz8JF+2ZlWQKBgQDXTmyRFmNK33R7AiSRteKVQ56iTwdtNWaWwusWskT/ajUvGtbYSoD0tQlFwUVQ4Xdol0IQLncM4YIq/9SaWdD3l+HaKXmND6/fCFaAOO5i561MEPKTqpPceO/De+i9vIo6fjz9hbMwBimMQI/YdlrjK0ioJm1unjN6LU6k42DSXQKBgQCskriTk/YdPerc8YF657S3ubAg5baN5a/UCEto+LH92NyoM2FjoBRGV7jEDiaHT7ztlzlCMOZXckRbYkXM3fbljhdl0raHqGsvceoEllqZn08uTbFQNXOhy3rj4iE5Mypw3X2c2Xr7HTwYDMOdcFzbKLzXoLHQqCt6SNjKpXTT7wKBgCXPYudzzAoZBcaYUL25+EmIL3KHeGFoUFTHdCtvMQi9qQtVpkcjhlPy+ubiEv8qKSMX9QUMc+GyNH7CoJ5eiYEBjisWv37TM2pyd2ZbGRoLX3aNP1xJR2AfaNOmje/MDWZKRwGqmhYj7uXvbJNx7XIZZtAIt40GgTnCfR4dxCINAoGACp9VYTAgXBhtln//GlOc2hpB7yR0ojNbKVABZEq6mgd5PZk8C2fVF6dapibA1F9iH7XJPnvIEeXks0NPTJb1FZgzdH8N4TfKsTbv0qx2kzItK4p4uZkwrurZe6F1rhGqMRxRGRCB82cPReOzPsOl04+kYBlyGIfhdTt6rK6WjF0CgYBauoe8UHrKqNdLWsj3kvZsUWoHRZtRHggJQakbFY4HnuTvB1IzDv4U1mn6k1mecJIk3Xxlsji1pVD0dIxEoS2bw+PuOgf0zT5YNTKvhjvxtbraRJ5xUR9Hpnz2CBeWLu+zDDI+SYFcVNk/+odE+Bv2Zmd58BiIHcJYRdFHp+19lA==";
	public static String FORMAT = "json";
	public static String CHARSET = "utf-8";
	// 支付宝公钥
	// 测试
//	public static String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAuU1ZUs11b+RRv4xL7EI1BXnZ2/YO4uBufV6Qr+meeJ/cqJi81C++aoNgymSEWeCabzkEyLLkpdvgoURcai9QW2QpAF/5dD4Q3u9GJHPQtVq/c2HQYyBNsqNDyde+FxehTC8ZZwnxUqqqWsJzOGYwM5kPM2TYFYkZXKNiwAXM5YoiW6fiwJVUzPXpf0WiMoXdop1y/iyja6/0eRrMdBvaQIqJ74y6Obxo1vjEitmjb2AYCTFzJ/gHb0q8wu8wAujdhIiGNLc56kx8ph/sL0BTY3AGfspXdV9OpxsAU93J4vCgfuzTGDFzyfM3ZYzO0+8sofLo/Auz+NbeMs09QpfuqwIDAQAB";
	public static String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAhXmeRcgut9fWInei61wNO1eXRO0sDORtj5LFhovZWVUnl2ufx81Ta8RQYskQdnBHWcum+OMHjnniLS0Wci9JhFszyChh8LEaJF3MXnx6xZD4vVE5WCDivTn2TM3ifuvr/hPgU9uypbG9azlbjWb8SmWCyHGonPs0t/BfBLn7TVTiHBhvJM8dV0a5JT5e8hZQCLF7gCCJ2hW6xhZPNucY1DDoixMv1iO2QTxcjGDZEoDglicnjKfkzZ0BzBJYIY5ehujZYOffGZUnGLhseRx1Hs9Wg1NT5RNV3bckG8Nl203IWM9ZSxK5pJ8FgVjLbwy5dZrLrQIiC8XeA8MSsidSKwIDAQAB";

	public static String SIGN_TYPE = "RSA2";

	private AlipayClient alipayClient = new DefaultAlipayClient(URL, APP_ID, APP_PRIVATE_KEY, FORMAT, CHARSET,
			ALIPAY_PUBLIC_KEY, SIGN_TYPE);

	private UsersService userServiceImpl;

	public AliPayUtil(UsersService userServiceImpl) {
		this.userServiceImpl = userServiceImpl;
	}

	// @PostMapping("/pay")
	// @ResponseBody
	public JSONObject pay(HttpServletRequest req) {
		JSONObject object = new JSONObject();
		HashMap<String,Object> map=new HashMap<>();
		// 进入支付
		System.err.println("进入支付，服务器端封装订单信息，返回客户端吊起支付");
		/**
		 * { "timeout_express":"30m", "seller_id":"",
		 * "product_code":"QUICK_MSECURITY_PAY", "total_amount":"0.02",
		 * "subject":"1", "body":"我是测试数据", "out_trade_no":"314VYGIAGG7ZOYY" }
		 */
		// 实例化具体API对应的request类,类名称和接口名称对应,当前调用接口名称：alipay.trade.app.pay
		AlipayTradeAppPayRequest request = new AlipayTradeAppPayRequest();
		// SDK已经封装掉了公共参数，这里只需要传入业务参数。以下方法为sdk的model入参方式(model和biz_content同时存在的情况下取biz_content)。
		AlipayTradeAppPayModel model = new AlipayTradeAppPayModel();
		model.setBody("充值"); // 交易的描述信息
		model.setSubject((String) req.getAttribute("title"));// 商品交易的标题
		// 请保证OutTradeNo值每次保证唯一
		String numeric = System.currentTimeMillis() + RandomStringUtils.randomNumeric(6);
		model.setOutTradeNo(numeric); // 订单号唯一
		model.setTimeoutExpress("30m");
		model.setSellerId(SellerId); // 收款账户
		// req.getParameter("money")
		String totalmoney = String.valueOf(req.getAttribute("totalMoney"));
		System.err.println(totalmoney);
		model.setTotalAmount(totalmoney);// 金额
		model.setProductCode("QUICK_MSECURITY_PAY");
		request.setBizModel(model);
		request.setNotifyUrl("http://39.104.187.43/control/app_alipayCallBack");
		// 这里和普通的接口调用不同，使用的是sdkExecute
		try {
			HbUser user = this.userServiceImpl.selectUserObject(String.valueOf(req.getAttribute("telephone")));
			if(user==null){
				object.put("msg", "该手机用户不存在");
				object.put("code", "400");
				return object;
			}
			/**
			 * 保存订单信息
			 */
			/**
			 * request.setAttribute("title", "缴纳押金");
			 * request.setAttribute("telephone", telephone);
			 * request.setAttribute("cashMoney", cashMoney);
			 * request.setAttribute("money", money);
			 * request.setAttribute("totalMoney", totalMoney);
			 * request.setAttribute("cashType", type);
			 * request.setAttribute("type", "0");
			 */
			String type = String.valueOf(req.getAttribute("type"));
			HbOrder order = new HbOrder();
			if (type.equals("0")) { // 押金
				HbUserCash cash = new HbUserCash();
				cash.setUserId(user.getUserId());
				cash.setUserAccountMoney(String.valueOf(req.getAttribute("money")));
				cash.setUserCash(Double.parseDouble(String.valueOf(req.getAttribute("cashMoney"))));
				cash.setUserCashType(Integer.parseInt(String.valueOf(req.getAttribute("cashType"))));
				cash.setUserCashStatus(2);
				//保存押金信息
				this.userServiceImpl.saveUserCash(cash);
				order.setOrderCashId(user.getUserId());
				order.setOrderType(0);
			}else if(type.equals("3")){//固定金额支付
				order.setOrderType(3);
				order.setOrderCashId(null);
				order.setOrderFixed("1");
			}else{
				order.setOrderType(1);
				order.setOrderCashId(null);
			}
			order.setOrderId(numeric);
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			order.setOrderCreatetime(format.parse(format.format(new Date())));
			order.setOrderPrice(Double.parseDouble(String.valueOf(req.getAttribute("totalMoney"))));
			order.setOrderUserid(user.getUserId());
			this.userServiceImpl.saveOrder(order);
			AlipayTradeAppPayResponse response = alipayClient.sdkExecute(request);
			String body = response.getBody();
			object.put("msg", "签名获取成功");
			map.put("sdk",body);
			map.put("orderid",numeric);
			object.put("data", map);
			object.put("code", "200");
			return object;
		} catch (Exception e) {
			e.printStackTrace();
		}
		object.put("msg", "签名获取失败");
		object.put("code", "400");
		return object;
	}
}
