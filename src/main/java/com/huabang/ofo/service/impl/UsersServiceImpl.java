package com.huabang.ofo.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.alibaba.fastjson.JSONObject;
import com.huabang.ofo.controller.Tencent;
import com.huabang.ofo.dao.HbAccountsMapper;
import com.huabang.ofo.dao.HbImagesMapper;
import com.huabang.ofo.dao.HbOrdersMapper;
import com.huabang.ofo.dao.HbSharesMapper;
import com.huabang.ofo.dao.HbUserCashsMapper;
import com.huabang.ofo.dao.HbUsersMapper;
import com.huabang.ofo.domain.HbAccount;
import com.huabang.ofo.domain.HbImage;
import com.huabang.ofo.domain.HbOrder;
import com.huabang.ofo.domain.HbShare;
import com.huabang.ofo.domain.HbUser;
import com.huabang.ofo.domain.HbUserCash;
import com.huabang.ofo.service.UsersService;
import com.refund.impl;

@Service
@Transactional(propagation=Propagation.REQUIRED)
public class UsersServiceImpl implements UsersService,Tencent {
	@Autowired
	private HbSharesMapper hbShareMapper;
	@Autowired
	private HbUsersMapper hbUserMapper;
	@Autowired
	private HbUserCashsMapper hbUserCashMapper;
	@Autowired
	private HbAccountsMapper hbAccountMapper;
	@Autowired
	private HbImagesMapper hbImageMapper;
	@Autowired
	private HbOrdersMapper hbOrderMapper;
	
	@Override
	public Map<String,Object> login(String telephone) {
		Map<String,Object> map = new HashMap<>();
		Map<String,String> datamap=new HashMap<String,String>();
		map.put("code", "200");
		//查询该手机号用户是否已经注册过
		HbUser user = this.hbUserMapper.selectByPhone(telephone);
		//注册过
		if(user!=null){
			datamap.put("userId", user.getUserId());
			datamap.put("userPhone", user.getUserPhone());
			//查询用户是否已经缴纳押金
			HbUserCash userCash = this.hbUserCashMapper.selectByPrimaryKey2(user.getUserId());
			if(userCash==null){
				datamap.put("cashtype", "0");
			}else{
				datamap.put("cashtype", "1");
			}
			HbShare share =hbShareMapper.findByUseridAndStatus(user.getUserId(),"1");
			if(share!=null){
				datamap.put("type", "1");
				datamap.put("shareId", share.getShareId());
			}else{
				datamap.put("type", "0");
				datamap.put("shareId", "");
			}
			map.put("data", datamap);
			return map; 
		}
		//没有注册过,注释掉的有默认值
		HbUser hbUser = new HbUser();
		hbUser.setUserId(UUID.randomUUID().toString().replace("-", ""));
		hbUser.setUserPhone(telephone);
		hbUser.setUserName(telephone);
//		hbUser.setUserXyapprove(0);  信誉分
//		hbUser.setUserBirthday(null); 生日
//		hbUser.setUserSex(null);  性别
		//hbUser.setUserImage(imageUrl+"default.jpg");
		hbUser.setUserImage("/src/main/resources/static/image/default.jpg");
		
//		hbUser.setUserApprove(0);
//		hbUser.setUserStatus(0);
//		hbUser.setUserWeixin(null);
//		hbUser.setUserQq(null);
//		hbUser.setUserInvite(null);
		//保存用户的基本信息
		this.hbUserMapper.insertSelective(hbUser);
		HbAccount account = new HbAccount();
		account.setAccountUserId(hbUser.getUserId());
		account.setAccountPay(0.0);
		account.setAccountPresented(0.0);
		account.setAccountTotel("0.00");
		//保存用户的初始账户余额
		this.hbAccountMapper.insertSelective(account);
		datamap.put("userId", hbUser.getUserId());
		datamap.put("userPhone", hbUser.getUserPhone());
		datamap.put("cashtype", "0");
		datamap.put("type", "0");
		datamap.put("shareId", "");
		map.put("data", datamap);
		return map;
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED,readOnly=true)
	public HbAccount selectMoney(String telephone) {
		HbAccount hb = this.hbAccountMapper.selectMoney(telephone);
		return hb;
	}

	@Override
	public String savaImage(Integer type, String fileName, String telephone) {
		HbImage image = new HbImage();
		if(type==0){//头像
			HbUser user = this.hbUserMapper.selectByPhone(telephone);
			if(user==null){
				return null;
			}
			//user.setUserImage(imageUrl+fileName);
			user.setUserImage(fileName);
			this.hbUserMapper.updateByPrimaryKeySelective(user);
			image.setImageUserId(user.getUserId());
		}else{
			image.setImageUserId(null);
		}
		//image.setImagePic(imageUrl+fileName);
				image.setImagePic(fileName);
				image.setImageType(type.toString());
		this.hbImageMapper.insertSelective(image);
		return image.getImagePic();
	}

	@Override
	public int updateByName(String telePhone, String value,int type) {
		HbUser user = this.hbUserMapper.selectByPhone(telePhone);
		//修改昵称
		if(type==0){
			user.setUserName(value);
		}else if(type==1){
			//修改性别
			if("男".equals(value)){
				user.setUserSex("0");
			}else{
				user.setUserSex("1");
			}
		}else if(type==2){
			//修改生日
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date date = null;
			try {
				date = format.parse(value);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			user.setUserBirthday(date);
		}else{
			return 0;
		}
		int i = this.hbUserMapper.updateByPrimaryKeySelective(user);
		return i;
	}

	@Override
	public int updateByPhone(String oldPhone, String newPhone) {
		HbUser user = this.hbUserMapper.selectByPhone(oldPhone);
		user.setUserPhone(newPhone);
		int i = this.hbUserMapper.updateByPrimaryKeySelective(user);
		return i;
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED,readOnly=true)
	public String selectUser(String telephone) {
		HbUser user = this.hbUserMapper.selectByPhone(telephone);
		JSONObject object = new JSONObject();
		HashMap<String,Object> datamap=new HashMap<>(); 
		if(user==null){
			object.put("code","400");
			object.put("msg","用户不存在");
			return object.toJSONString();
		}
		object.put("code","200");
		if(user.getUserApprove() == 0){
			datamap.put("renzheng", "未认证");
		}else{
			datamap.put("renzheng", "已认证");
		}
		if(user.getUserSex() == null || user.getUserSex().equals("")){
			user.setUserSex("未设置");
		}else{
			if(user.getUserSex().equals("0")){
				user.setUserSex("男");
			}else{
				user.setUserSex("女");
			}
		}
		datamap.put("user", user);
		object.put("data", datamap);
		return object.toJSONString();
	}

	@Override
	public String renZheng(String telephone, String cashMoney, int type,Integer money,HttpServletRequest request) {
		HbUser user = this.hbUserMapper.selectByPhone(telephone);
		//押金保存
		HbUserCash hbUserCash = new HbUserCash();
		hbUserCash.setUserId(user.getUserId());
		hbUserCash.setUserCash(Double.parseDouble(cashMoney));
		hbUserCash.setUserCashType(type);
		//缴纳押金并充值余额
		if(money!=0){
			HbAccount account = this.hbAccountMapper.selectByUserId(user.getUserId());
			account.setAccountTotel(String.valueOf(Double.parseDouble(account.getAccountTotel()+money)));
			account.setAccountPay(Double.parseDouble(account.getAccountTotel()));
			this.hbAccountMapper.updateByPrimaryKeySelective(account);
		}
		int i = this.hbUserCashMapper.insertSelective(hbUserCash);
		//订单保存
		HbOrder order = new HbOrder();
		order.setOrderId(UUID.randomUUID().toString().replace("-", ""));
		order.setOrderPrice(Double.parseDouble(cashMoney)+money);
		order.setOrderUserid(user.getUserId());
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			order.setOrderCreatetime(format.parse(format.format(new Date())));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		order.setOrderType(0);
		int j = this.hbOrderMapper.insertSelective(order);
		user.setUserApprove(1);
		//修改用户的认证
		this.hbUserMapper.updateByPrimaryKeySelective(user);
		JSONObject object = new JSONObject();
		if(i>0&&j>0){
			object.put("result", "ok");
		}else{
			object.put("result", "error");
		}
		return object.toJSONString();
	}

	@Override
	public String pay(String telephone, String money) {
		//余额
		HbUser user = this.hbUserMapper.selectByPhone(telephone);
		HbAccount account = this.hbAccountMapper.selectByUserId(user.getUserId());
		account.setAccountTotel(String.valueOf(Double.parseDouble(account.getAccountTotel()+Double.parseDouble(money))));
		account.setAccountPay(Double.parseDouble(account.getAccountTotel()));
		int i = this.hbAccountMapper.updateByPrimaryKeySelective(account);
		//订单
		HbOrder order = new HbOrder();
		order.setOrderId(UUID.randomUUID().toString().replace("-", ""));
		order.setOrderPrice(Double.parseDouble(money));
		order.setOrderUserid(user.getUserId());
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			order.setOrderCreatetime(format.parse(format.format(new Date())));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		order.setOrderType(1);
		int j = this.hbOrderMapper.insertSelective(order);
		JSONObject object = new JSONObject();
		if(i>0&&j>0){
			object.put("result", "ok");
		}else{
			object.put("result", "error");
		}
		return object.toJSONString();
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED,readOnly=true)
	public String selectUserMe(String telephone) {
		JSONObject object = new JSONObject();
		object.put("code", "200");
		object.put("msg", "获取用户信息成功");
		try{
			HbUser user = this.hbUserMapper.selectByPhone(telephone);
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("phone", telephone);
			if(user.getUserApprove() == 0){
				map.put("renzheng", "未认证");
			}else{
				map.put("renzheng", "已认证");
			}
			map.put("xyapprove", user.getUserXyapprove());
			map.put("imageUrl", user.getUserImage());
			map.put("username", user.getUserName());
			HbAccount account = this.hbAccountMapper.selectByUserId(user.getUserId());
			map.put("money", account.getAccountTotel());
			object.put("data", map);
		}catch(Exception e){
			e.printStackTrace();
			object.put("code", "400");
			object.put("msg", "获取用户信息失败");
		}
		return object.toJSONString();
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED,readOnly=true)
	public String selectMyMoney(String userId) {
		HbAccount account = this.hbAccountMapper.selectByUserId(userId);
		HbUserCash cash = this.hbUserCashMapper.selectByPrimaryKey2(userId);
		JSONObject object = new JSONObject();
		HashMap<String,Object> datamap=new HashMap<>(); 
		if(cash == null){
			datamap.put("yajin", 0);
		}else{
			datamap.put("yajin", cash.getUserCash());
		}
		if(account==null){
			object.put("code", "400");
			object.put("msg", "获取用户金额失败");
			return object.toJSONString();
		}
		datamap.put("money", account.getAccountTotel());
		object.put("code", "200");
		object.put("data", datamap);
		return object.toJSONString();
	}

	@Override
	public HbUser selectUserObject(String valueOf) {
		HbUser user = this.hbUserMapper.selectByPhone(valueOf);
		return user;
	}

	@Override
	public void saveUserCash(HbUserCash cash) {
		HbUserCash selectByPrimaryKey = hbUserCashMapper.selectByPrimaryKey(cash.getUserId());
		if(selectByPrimaryKey==null){
			this.hbUserCashMapper.insertSelective(cash);
		}else{
			this.hbUserCashMapper.updateByPrimaryKeySelective(cash);
		}
	}

	@Override
	public void saveOrder(HbOrder order) {
		this.hbOrderMapper.insert(order);
	}

	@Override
	public JSONObject refund(HttpServletRequest request) {
		String telephone = request.getParameter("telephone");
		HbUser user = this.hbUserMapper.selectByPhone(telephone);
		HbUserCash userCash = this.hbUserCashMapper.selectByPrimaryKey2(user.getUserId());
		return new impl().refund(request,userCash,hbUserCashMapper);
	}

}
