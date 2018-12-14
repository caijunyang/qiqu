package com.huabang.ofo.service.impl;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jdom.JDOMException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONObject;
import com.alipay.api.internal.util.AlipaySignature;
import com.aliyuncs.http.HttpResponse;
import com.huabang.ofo.dao.HbAccountsMapper;
import com.huabang.ofo.dao.HbCashmoneysMapper;
import com.huabang.ofo.dao.HbOrdersMapper;
import com.huabang.ofo.dao.HbPaymoneysMapper;
import com.huabang.ofo.dao.HbUserCashsMapper;
import com.huabang.ofo.dao.HbUsersMapper;
import com.huabang.ofo.domain.HbAccount;
import com.huabang.ofo.domain.HbCashmoney;
import com.huabang.ofo.domain.HbOrder;
import com.huabang.ofo.domain.HbPaymoney;
import com.huabang.ofo.domain.HbUser;
import com.huabang.ofo.domain.HbUserCash;
import com.huabang.ofo.service.ControlService;
import com.huabang.ofo.utils.alipay.util.AliPayUtil;
import com.tenpay.util.XMLUtil;

@Service
@Transactional(propagation=Propagation.REQUIRED,readOnly=true)
public class ControlServiceImpl implements ControlService {

	@Autowired
	private HbCashmoneysMapper hbCashMoneyMapper;
	@Autowired
	private HbPaymoneysMapper hbPayMoneyMapper;
	@Autowired
	private HbOrdersMapper hbOrdersMapper;
	@Autowired
	private HbUserCashsMapper hbUserCashMapper;
	@Autowired
	private HbAccountsMapper hbAccountMapper;
	@Autowired
	private HbUsersMapper hbuserMapper;
	
	@Override
	public String selectCashAll() {
		List<HbCashmoney> list = this.hbCashMoneyMapper.selectByExample(null);
		JSONObject object = new JSONObject();
		object.put("list", list);
		return object.toJSONString();
	}
	
	@Override
	public String selectPayAll() {
		List<HbPaymoney> list = this.hbPayMoneyMapper.selectByExample(null);
		JSONObject object = new JSONObject();
		object.put("list", list);
		return object.toJSONString();
	}

	private static Logger logger = LoggerFactory.getLogger(ControlServiceImpl.class);
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public String huiDiao(HttpServletRequest request) throws Exception {
		logger.info("支付宝回调=======================================");
		//获取支付宝POST过来反馈信息
        Map<String,String> params = new HashMap<String,String>();
        Map<String,String[]> requestParams = request.getParameterMap();
        for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            System.err.println("key:"+name+",value:"+Arrays.toString(values));
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                        : valueStr + values[i] + ",";
            }
            //乱码解决，这段代码在出现乱码时使用
//            valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
            params.put(name, valueStr);
        }
        //调用SDK验证签名
		boolean signVerified = AlipaySignature.rsaCheckV1(params, AliPayUtil.ALIPAY_PUBLIC_KEY, AliPayUtil.CHARSET,AliPayUtil.SIGN_TYPE);
		if(signVerified){
			logger.info("支付宝回调验证成功！！！！！！！！！！！！！！！！！！！！！！！！！！！"); 
			/**
	    	 * 	WAIT_BUYER_PAY	交易创建，等待买家付款
			 *	TRADE_CLOSED	未付款交易超时关闭，或支付完成后全额退款
			 *	TRADE_SUCCESS	交易支付成功
			 *	TRADE_FINISHED	交易结束，不可退款
	    	 */
	    	String trade_status=request.getParameter("trade_status");   //
			if(trade_status.equalsIgnoreCase("TRADE_SUCCESS")){		    //支付成功
				//通过自定义的订单号将该订单查询出来
				HbOrder order = this.hbOrdersMapper.selectByPrimaryKey(request.getParameter("out_trade_no"));
				if(order.getOrderCashId() == null){//充值或单次
					if(order.getOrderFixed()==null || order.getOrderFixed().equals("0")){
						HbUser user = this.hbuserMapper.selectByPrimaryKey(order.getOrderUserid());
						HbAccount account = this.hbAccountMapper.selectByUserId(user.getUserId());
						account.setAccountTotel(String.valueOf(Double.parseDouble(account.getAccountTotel())+order.getOrderPrice()));
						// account.setAccountPay(Double.parseDouble(account.getAccountTotel()));
						this.hbAccountMapper.updateByPrimaryKey(account);
					}
					//修改订单状态
					hbOrdersMapper.updateStatus(request.getParameter("out_trade_no"),"1");
				}else{ // 押金
					//押金的修改
					String orderCashId = order.getOrderCashId();
					HbUserCash cash = this.hbUserCashMapper.selectByPrimaryKey(orderCashId);
					cash.setUserCashStatus(0);
					this.hbUserCashMapper.updateByPrimaryKeySelective(cash);
					//用户账户余额的修改
					//if(cash.getUserAccountMoney()!=null ||cash.getUserAccountMoney().equals("") ){
					//	HbAccount account = this.hbAccountMapper.selectByUserId(order.getOrderUserid());
					//	account.setAccountTotel(String.valueOf(Double.parseDouble(account.getAccountTotel())+Double.parseDouble(cash.getUserAccountMoney())));
					//	account.setAccountPay(Double.parseDouble(account.getAccountTotel()));
						// this.hbAccountMapper.updateByPrimaryKeySelective(account);
					//}
					//修改订单状态
					hbOrdersMapper.updateStatus(request.getParameter("out_trade_no"),"1");
					//修改用户的认证状态
					HbUser user = this.hbuserMapper.selectByPrimaryKey(orderCashId);
					user.setUserApprove(1);
					this.hbuserMapper.updateByPrimaryKeySelective(user);
				}
			}
			return "success";
		}else{
			logger.info("支付宝回调验证失败！！！！！！！！！！！！！！！！！！！！！！！！！！！"); 
			//hbOrdersMapper.deleteByPrimaryKey(request.getParameter("out_trade_no"));
			return "error";
		}
	}

	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void weixhuiDiao(HttpServletRequest request,HttpServletResponse response) throws Exception{
		System.out.println("微信支付回调");
        PrintWriter writer = response.getWriter();
        InputStream inStream = request.getInputStream();
        ByteArrayOutputStream outSteam = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        while ((len = inStream.read(buffer)) != -1) {
            outSteam.write(buffer, 0, len);
        }
        outSteam.close();
        inStream.close();
        String result = new String(outSteam.toByteArray(), "utf-8");
        System.out.println("微信支付通知结果：" + result);
        Map<String, String> map = null;
        try {
            /**
             * 解析微信通知返回的信息
             */
            map = XMLUtil.doXMLParse(result);
        } catch (JDOMException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("=========:"+result);
        // 若支付成功，则告知微信服务器收到通知
        if (map.get("return_code").equals("SUCCESS")) {
            if (map.get("result_code").equals("SUCCESS")) {
                System.out.println("充值成功！");
                
              //通过自定义的订单号将该订单查询出来
                String string = Long.valueOf(map.get("out_trade_no")).toString();
				HbOrder order = this.hbOrdersMapper.selectByPrimaryKey(string);
				if(order.getOrderCashId() == null){//充值
					if(order.getOrderFixed()==null || order.getOrderFixed().equals("0")){
						HbUser user = this.hbuserMapper.selectByPrimaryKey(order.getOrderUserid());
						HbAccount account = this.hbAccountMapper.selectByUserId(user.getUserId());
						account.setAccountTotel(String.valueOf(Double.parseDouble(account.getAccountTotel())+order.getOrderPrice()));
						// account.setAccountPay(Double.parseDouble(account.getAccountTotel()));
						this.hbAccountMapper.updateByPrimaryKey(account);
					}
					//修改订单状态
					hbOrdersMapper.updateStatus(map.get("out_trade_no"),"1");
				}else{ // 押金
					//押金的修改
					String orderCashId = order.getOrderCashId();
					HbUserCash cash = this.hbUserCashMapper.selectByPrimaryKey(orderCashId);
					cash.setUserCashStatus(0);
					this.hbUserCashMapper.updateByPrimaryKeySelective(cash);
					//用户账户余额的修改
					//if(cash.getUserAccountMoney()!=null ||cash.getUserAccountMoney().equals("") ){
					//	HbAccount account = this.hbAccountMapper.selectByUserId(order.getOrderUserid());
					//	account.setAccountTotel(String.valueOf(Double.parseDouble(account.getAccountTotel())+Double.parseDouble(cash.getUserAccountMoney())));
					//	account.setAccountPay(Double.parseDouble(account.getAccountTotel()));
						// this.hbAccountMapper.updateByPrimaryKeySelective(account);
					//}
					//修改订单状态
					hbOrdersMapper.updateStatus(map.get("out_trade_no"),"1");
					//修改用户的认证状态
					HbUser user = this.hbuserMapper.selectByPrimaryKey(orderCashId);
					user.setUserApprove(1);
					this.hbuserMapper.updateByPrimaryKeySelective(user);
				}
                
                System.out.println("订单号："+Long.valueOf(map.get("out_trade_no")));
                System.out.println("通知微信后台");
                String notifyStr = XMLUtil.setXML("SUCCESS", "");
                writer.write(notifyStr);
                writer.flush();
            }
        }
	}
	
}
/*Map<String, Object> updateMap=new HashMap<>();
updateMap.put("notify_time", request.getParameter("notify_time")); //通知时间
updateMap.put("subject", request.getParameter("subject")); //商品名称
updateMap.put("trade_no", request.getParameter("trade_no")); //支付宝系统中的交易流水号
updateMap.put("trade_status", trade_status); //交易状态
updateMap.put("seller_id", request.getParameter("seller_id")); //卖家支付宝用户号 以2088开头的纯16位数字
updateMap.put("buyer_id", request.getParameter("buyer_id"));  //买家支付宝账号对应的支付宝唯一用户号。以2088开头的纯16位数字
updateMap.put("total_fee", request.getParameter("total_fee" )); //该笔订单的总金额,单位为元
updateMap.put("gmt_create", request.getParameter("gmt_create")); //该笔交易创建的时间
updateMap.put("gmt_payment", request.getParameter("gmt_payment"));  //该笔交易的买家付款时间
updateMap.put("discount", request.getParameter("discount"));  //支付宝系统会把discount的值加到交易金额上，如果有折扣，本参数为负数，单位为元
updateMap.put("refund_status", request.getParameter("refund_status")); //退款状态
updateMap.put("gmt_refund", request.getParameter("gmt_refund"));  //退款时间
updateMap.put("paramLinkString", paramLinkString);  // 
updateMap.put("out_trade_no", request.getParameter("out_trade_no"));  //商户网站唯一订单号
*/
