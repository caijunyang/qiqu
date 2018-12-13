package com.huabang.ofo.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.RandomStringUtils;
import org.jdom.JDOMException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bootdo.ofo.domain.HbCashmoney;
import com.bootdo.ofo.domain.HbPaymoney;
import com.bootdo.ofo.service.CashService;
import com.bootdo.ofo.service.MoneyService;
import com.huabang.ofo.dao.HbJourneysMapper;
import com.huabang.ofo.dao.HbOrdersMapper;
import com.huabang.ofo.dao.HbUserCashsMapper;
import com.huabang.ofo.domain.HbAccount;
import com.huabang.ofo.domain.HbAuthcode;
import com.huabang.ofo.domain.HbJourney;
import com.huabang.ofo.domain.HbOrder;
import com.huabang.ofo.domain.HbUser;
import com.huabang.ofo.domain.HbUserCash;
import com.huabang.ofo.service.HbAuthcodeService;
import com.huabang.ofo.service.UsersService;
import com.huabang.ofo.utils.FileUtil;
import com.huabang.ofo.utils.SendMsgUtils2;
import com.huabang.ofo.utils.alipay.util.AliPayUtil;
import com.huabang.ofo.utils.weixin.Utils.WeixinPayUtil;
import com.refund.impl;
import com.tenpay.util.HttpClientUtil;

@Controller
@RequestMapping("/user")
public class UsersController{

	@Autowired
	private UsersService userServiceImpl;
	@Autowired
	private HbAuthcodeService hAuthcodeService;
	@Autowired
	private CashService cashService;
	@Autowired
	private MoneyService moneyService;
	@Autowired
	private HbOrdersMapper hbOrdersMapper;
	@Autowired
	private HbJourneysMapper hbJourneyMapper;
	@Autowired
	private HbUserCashsMapper hbUserCashMapper;
	/**
	 * 发送验证码
	 * 
	 * @param Phone
	 * @return
	 * @throws Exception
	 */
	@PostMapping(value = "/send")
	@ResponseBody
	public String customer_sendMsg(@RequestParam Map<String,String> map) throws Exception {
		JSONObject jsonObject = new JSONObject();
		String telephone = (String)map.get("telephone");
		if(telephone == null || "".equals(telephone)){
			jsonObject.put("msg", "请输入手机号");
			jsonObject.put("code", "400");
			return jsonObject.toJSONString();
		} 
		String regex = "^1[3|4|5|7|8][0-9]\\d{8}$";
		Pattern p = Pattern.compile(regex);  
		Matcher m = p.matcher(telephone);  
		if(!m.matches()){
			jsonObject.put("msg", "对不起，输入的手机号有误");
			jsonObject.put("code", "400");
			return jsonObject.toJSONString();
		}
		String checkcode = RandomStringUtils.randomNumeric(4);
		try {
//			SendSmsResponse sms = SendMsgUtils.sendSms(telephone, checkcode);
//			if(sms){
//				jsonObject.put("msg", "发送失败，请重试");
//				return jsonObject.toJSONString();
//			}
			Integer count=hAuthcodeService.findTelephone(telephone);
			if(count==0){
				hAuthcodeService.addCode(telephone, checkcode,new Date().getTime());
			}else{
				hAuthcodeService.updateCode(telephone, checkcode,new Date().getTime());
			}
			Boolean sms = SendMsgUtils2.sendSms(telephone, checkcode);
			jsonObject.put("msg", "发送成功，请注意查收");
			jsonObject.put("code", "200");
			return jsonObject.toJSONString();
		} catch (Exception e) {
			e.printStackTrace();
			jsonObject.put("msg", "发送失败，请重试");
			jsonObject.put("code", "400");
			return jsonObject.toJSONString();
		}
	}

	/**
	 * 用户登陆/注册
	 * 
	 * @param telephone
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> login(@RequestParam Map<String,String> map) {
		Map<String, Object> resultmap = new HashMap<String, Object>();
		resultmap.put("code", "400");
		String telephone = (String)map.get("telephone");
		String code = (String)map.get("authcode");
		if(code == null || "".equals(code)){
			resultmap.put("msg", "请输入验证码");
			return resultmap;
		}
		long time = new Date().getTime();
		time=time-5*60*1000;
		hAuthcodeService.delBytime(time);
		HbAuthcode hbAuthcode=hAuthcodeService.selectByTelephone(telephone);
		if(hbAuthcode==null){
			resultmap.put("msg", "验证码已失效");
			return resultmap;
		}
		String authcode = hbAuthcode.getAuthcode();
		if(!authcode.equals(code)){
			resultmap.put("msg", "验证码错误");
			return resultmap;
		}
		Map<String, Object> result = this.userServiceImpl.login(telephone);
		return result;
	}
	
	/**
	 * 查看用户的基本信息
	 * @param telephone
	 * @return
	 */
	@PostMapping("/selectUser")
	@ResponseBody
	public String selectUser(@RequestParam Map<String,String> map){
		String telephone = (String)map.get("telephone");
		String result = this.userServiceImpl.selectUser(telephone);
		return result;
	}
	
	/**
	 * 我  页面的数据
	 * @param telephone
	 * @return
	 */
	@PostMapping("/selectUserMe")
	@ResponseBody
	public String userMe(@RequestParam Map<String,String> map){
		String telephone = (String)map.get("telephone");
		String result = this.userServiceImpl.selectUserMe(telephone);
		return result;
	}

	/**
	 * 上传图片
	 * 
	 * @param file
	 * @param request
	 * @return 
	 * @return
	 */
	@ResponseBody
	@PostMapping(value = "/uploadimg")
	public JSONObject upload(@RequestParam("files") MultipartFile file, HttpServletRequest request,@RequestParam Map<String,String> map) {
		JSONObject jsonObject = new JSONObject();
		String path = request.getSession().getServletContext().getRealPath("src/main/resources/static/image/");
		String telephone = (String)map.get("telephone");
		Integer type = Integer.parseInt(map.get("type"));
		String fileName = file.getOriginalFilename();
		fileName = FileUtil.renameToUUID(fileName).replace("-", "");
		try {
			FileUtil.uploadFile(file.getBytes(), path, fileName);
			//保存数据库
			String image = this.userServiceImpl.savaImage(type,"/src/main/resources/static/image/"+fileName,telephone);
			if(image==null){
				jsonObject.put("code", "400");
				jsonObject.put("msg","该手机用户不存在");
				return jsonObject;
			}
			HashMap<String,String> datamap=new HashMap<String,String>();
			jsonObject.put("code", "200");
			jsonObject.put("msg","图片上传成功");
			datamap.put("imageUrl", image);
			jsonObject.put("data",datamap);
		} catch (Exception e) {
			jsonObject.put("code", "400");
			jsonObject.put("msg","图片上传失败");
			e.printStackTrace();
		}
		return jsonObject;
	}

	/**
	 * 余额查询
	 * @param telephone
	 * @return
	 */
	@PostMapping("/money")
	@ResponseBody
	public String selectYuE(@RequestParam Map<String,String> map){
		String telephone = (String)map.get("telephone");
		HbAccount hbAccount = this.userServiceImpl.selectMoney(telephone);
		JSONObject object = new JSONObject();
		if(hbAccount==null){
			object.put("code","400");
			object.put("msg","该手机号余额信息不存在");
		}else{
			object.put("code","200");
			object.put("data", hbAccount);
		}
		return object.toJSONString();
	}
	
	/**
	 * 修改用户基本信息
	 * @param telePhone
	 * @param name
	 * @return
	 */
	@PostMapping("/name")
	@ResponseBody
	public String updateName(@RequestParam Map<String,String> map){
		JSONObject jsonObject = new JSONObject();
		String telePhone = (String)map.get("telephone");
		String value = (String)map.get("value");
		Integer type = Integer.parseInt(map.get("type"));
		int result = this.userServiceImpl.updateByName(telePhone,value,type);
		if(result>0){
			jsonObject.put("msg", "修改成功");
			jsonObject.put("code", "200");
			return jsonObject.toJSONString();
		}
		jsonObject.put("code", "400");
		jsonObject.put("msg", "修改失败");
		return jsonObject.toJSONString();
	}
	/**
	 * 更换手机号
	 * @param oldPhone
	 * @param newPhone
	 * @return
	 */
	@PostMapping("/phone")
	@ResponseBody
	public String updatePhone(@RequestParam Map<String,String> map){
		JSONObject jsonObject = new JSONObject();
		String oldPhone = (String)map.get("oldphone");
		String newPhone = (String)map.get("newphone");
		int result = this.userServiceImpl.updateByPhone(oldPhone,newPhone);
		if(result>0){
			jsonObject.put("code", "200");
			jsonObject.put("msg", "修改成功");
			return jsonObject.toJSONString();
		}
		jsonObject.put("code", "400");
		jsonObject.put("msg", "修改失败");
		return jsonObject.toJSONString();
	}
	/**
	 * 缴纳押金
	 * @param telephone
	 * @param money
	 * @param type
	 * @return
	 */
	@PostMapping("/payCashMoney")
	@ResponseBody												
	public JSONObject renZheng(@RequestParam Map<String,String> map,HttpServletRequest request, HttpServletResponse response){
		
		String telephone = (String)map.get("telephone");
		String type = (String)map.get("type");
		//String client = (String)map.getOrDefault("client","1");//客户端类型 2为小程序，其他为APP，可以空，空为APP
		String openid = (String)map.getOrDefault("openid","0");
		List<HbCashmoney> searchMoney = cashService.searchMoney();
		Integer cashMoney = searchMoney.get(0).getCashMoney();
		
		request.setAttribute("title", "缴纳押金");
		request.setAttribute("cashMoney", cashMoney);
		request.setAttribute("money", cashMoney);
		request.setAttribute("totalMoney", cashMoney);
		request.setAttribute("cashType", "0");
		request.setAttribute("telephone", telephone);
		request.setAttribute("type", "0");
		request.setAttribute("openid", openid);
		JSONObject pay=new JSONObject();
		
		HbUser user = this.userServiceImpl.selectUserObject(String.valueOf(request.getAttribute("telephone")));
		if(user==null){
			pay.put("msg", "该手机用户不存在");
			pay.put("code", "400");
			return pay;
		}
		HbUserCash userCash = hbUserCashMapper.selectByPrimaryKey2(user.getUserId());
		if(userCash!=null){
			pay.put("msg", "押金已经缴纳");
			pay.put("code", "400");
			return pay;
		}
		if(type.equals("aliy")){
			//AliPayUtil util = new AliPayUtil(userServiceImpl);
			// pay = util.pay(request); 
			pay.put("code", "400");
			pay.put("msg", "押金充值暂时关闭支付宝功能");
			return pay;
		}else if(type.equals("weix")){
			WeixinPayUtil util = new WeixinPayUtil(userServiceImpl);
			 pay = util.pay(request,response);
		}
//		String result = this.userServiceImpl.renZheng(telephone,cashMoney,type,money,request);
		return pay;
	}
	/**
	 * 充值
	 * @param telephone
	 * @param money
	 * @return
	 */
	@PostMapping("/pay")
	@ResponseBody
	public JSONObject pay(@RequestParam Map<String,String> map,HttpServletRequest request, HttpServletResponse response){
		String telephone = (String)map.get("telephone");
		String money = (String)map.get("money");
		String type = (String)map.get("type");//aliy:支付宝,weix:微信支付
		String openid = (String)map.getOrDefault("openid","0");
	
		request.setAttribute("title", "充值余额");
		request.setAttribute("totalMoney", money);
		request.setAttribute("telephone", telephone);
		request.setAttribute("type", "1");
		request.setAttribute("openid", openid);
		if(type.equals("aliy")){
			AliPayUtil util = new AliPayUtil(userServiceImpl);
			JSONObject pay = util.pay(request);
			return pay;
		}else if(type.equals("weix")){
			WeixinPayUtil util = new WeixinPayUtil(userServiceImpl);
			JSONObject pay = util.pay(request,response);
			return pay;
		}
		return null;
	}
	
	
	//退款接口
	@RequestMapping("/returnMoney")
	@ResponseBody
	public JSONObject returMoney(HttpServletRequest request) throws UnsupportedEncodingException {
	//根据订单号查出金额和积分
	JSONObject JSONObject=userServiceImpl.refund(request);
	return JSONObject;

	}
	
	/**
	 * 我的钱包
	 */
	@PostMapping("/selectMyMoney")
	@ResponseBody
	public String select(@RequestParam Map<String,String> map){
		String userId = map.get("userId");
		String result = this.userServiceImpl.selectMyMoney(userId);
		return result;
	}
	
	/**
	 * 押金金额
	 */
	@PostMapping("/cashmoney")
	@ResponseBody
	public JSONObject cashmoney(){
		JSONObject jsonobject=new JSONObject();
		HashMap<String,Object> datamap=new HashMap<String,Object>();
		List<HbCashmoney> searchMoney = cashService.searchMoney();
		if(searchMoney.size()>0){
			jsonobject.put("code","200");
			datamap.put("cashmoney",searchMoney.get(0).getCashMoney());
		}else{
			jsonobject.put("code","400");
		}
		jsonobject.put("data",datamap);
		return jsonobject;
	}
	/**
	 * 充值金额设置
	 * */
	@PostMapping("/paymoneySZ")
	@ResponseBody
	public JSONObject paymoneySZ(){
		JSONObject jsonobject=new JSONObject();
		HashMap<String,Object> datamap=new HashMap<String,Object>();
		 List<HbPaymoney> searchMoney = moneyService.searchMoney();
		if(searchMoney.size()>0){
			jsonobject.put("code","200");
			datamap.put("paymoney",searchMoney);
		}else{
			jsonobject.put("code","400");
		}
		jsonobject.put("data",datamap);
		return jsonobject;
	}
	
	/**
	 *交易明细--充值,押金,退款
	 * */
	@PostMapping("/paydetail")
	@ResponseBody
	public JSONObject paydetail(@RequestParam Map<String,String> map){
		String userid = map.get("userid");
		JSONObject res=new JSONObject();
		res.put("code", "200");
		ArrayList<HashMap<String,Object>> datalist=new ArrayList<HashMap<String,Object>>();
		
		ArrayList<HbOrder> list=hbOrdersMapper.findByUserid2(userid);
		for (HbOrder hbOrder : list) {
			HashMap<String,Object> datamap=new HashMap<String,Object>();
			datamap.put("type",hbOrder.getOrderType());
			datamap.put("money",hbOrder.getOrderPrice());
			datamap.put("date",hbOrder.getOrderCreatetime());
			datalist.add(datamap);
		}
		
		HashMap<String,Object> datamap=new HashMap<String,Object>();
		datamap.put("detail", datalist);
		res.put("data", datamap);
		return res;
	}
	
	/**
	 *交易明细--消费
	 * */
	@PostMapping("/consumedetail")
	@ResponseBody
	public JSONObject consumedetail(@RequestParam Map<String,String> map){
		String userid = map.get("userid");
		JSONObject res=new JSONObject();
		res.put("code", "200");
		ArrayList<HashMap<String,Object>> datalist=new ArrayList<HashMap<String,Object>>();
		ArrayList<HbJourney> list2=hbJourneyMapper.findByUserid(userid);
		for (HbJourney hbJourney : list2) {
			HashMap<String,Object> datamap=new HashMap<String,Object>();
			datamap.put("money",hbJourney.getJourneyMoney());
			datamap.put("time",hbJourney.getJourneyTime());
			datamap.put("big",hbJourney.getJourneyCreatetime());
			datamap.put("end",hbJourney.getJourneyEndtime());
			datalist.add(datamap);
		}
		HashMap<String,Object> datamap=new HashMap<String,Object>();
		datamap.put("detail", datalist);
		res.put("data", datamap);
		return res;
	}
	/**
	 * 获取openid
	 * @throws IOException 
	 * @throws JDOMException 
	 */
	@PostMapping("/getopenid")
	@ResponseBody
	public JSONObject getOpenId(@RequestParam Map<String,String> map) throws IOException, JDOMException{
		String code = map.get("code");
		String url="https://api.weixin.qq.com/sns/jscode2session?appid=wxd4af668b52e7a183&secret=f2b1dceb66fe3f565d8be35e85ac2312&js_code=" + code + "&grant_type=authorization_code";
		JSONObject resJson= new JSONObject();
		//请求
		HttpURLConnection httpConnection = HttpClientUtil.getHttpURLConnection(url);
        httpConnection.setConnectTimeout(30 * 1000);
        httpConnection.setUseCaches(false);
        httpConnection.setDoInput(true);
        httpConnection.setDoOutput(true);
        httpConnection.setRequestMethod("GET");
       
        int responseCode = httpConnection.getResponseCode();
        
        InputStream inputStream = httpConnection.getInputStream();
        JSONObject data=new JSONObject();
        if(inputStream!=null) {
        	String resContent = HttpClientUtil.InputStreamTOString(inputStream,"utf8"); 
        	JSONObject temJson=JSON.parseObject(resContent);
        	System.out.println(temJson);
        	data.put("openid", temJson.getString("openid"));
        }
        inputStream.close();
        resJson.put("code", "200");
        resJson.put("msg", "");
        resJson.put("data", data);
	    return resJson;
	}
}
