package com.huabang.ofo.service.impl;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONObject;
import com.bootdo.ofo.dao.HbUserCashMapper;
import com.bootdo.ofo.domain.HbUserCash;
import com.huabang.ofo.dao.HbAccountsMapper;
import com.huabang.ofo.dao.HbDetailsMapper;
import com.huabang.ofo.dao.HbJourneysMapper;
import com.huabang.ofo.dao.HbSharesMapper;
import com.huabang.ofo.dao.HbUsersMapper;
import com.huabang.ofo.domain.HbAccount;
import com.huabang.ofo.domain.HbDetail;
import com.huabang.ofo.domain.HbJourney;
import com.huabang.ofo.domain.HbShare;
import com.huabang.ofo.domain.HbUser;
import com.huabang.ofo.service.BikeService;
import com.huabang.ofo.utils.LatAndLntUtils;

@Service
@Transactional(propagation=Propagation.REQUIRED)
public class BikeServiceImpl implements BikeService {

	@Autowired
	private HbJourneysMapper hbJourneyMapper;
	@Autowired
	private HbSharesMapper hbShareMapper;
	@Autowired
	private HbUsersMapper hbUserMapper;
	@Autowired
	private HbDetailsMapper hbDetailMapper;
	@Autowired
	private HbUserCashMapper hbUserCashMapper;
	@Autowired
	private HbAccountsMapper hbAccountMapper;
	
	@Override
	public JSONObject useBike2(String shareId, String telePhone) {
		HbShare share = this.hbShareMapper.selectByPrimaryKey(shareId);
		HbUser user = this.hbUserMapper.selectByPhone(telePhone);
		JSONObject object = new JSONObject();
		object.put("code","400");
		if (share == null) {
			object.put("msg", "车牌号不正确");
			return object;
		}
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		HbJourney journey = new HbJourney();
		journey.setJourneyId(UUID.randomUUID().toString().replace("-", ""));
		journey.setJourneyShareid(shareId);
		journey.setJourneyUserid(user.getUserId());
		try {
			journey.setJourneyCreatetime(format.parse(format.format(new Date())));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		journey.setJourneyStartpot(share.getSharePot());
		int i = this.hbJourneyMapper.insertSelective(journey);
		
		if(i>0){
			journey.setJourneyMoney(2.0);
			journey.setJourneyTime(-1);
			hbJourneyMapper.updateByPrimaryKeySelective(journey);
			// hbShareMapper.updateStatusAndUserByid("1",user.getUserId(),shareId);
			HbAccount account = this.hbAccountMapper.selectByUserId(user.getUserId());
			if(Double.parseDouble(account.getAccountTotel())<0){
				object.put("msg", "开启失败,余额不足");
				return object;
			}
			
			account.setAccountTotel(String.valueOf(Double.parseDouble(account.getAccountTotel())-2));
			this.hbAccountMapper.updateByPrimaryKey(account);
			object.put("msg", "使用成功");
			object.put("code","200");
			return object;
		}
		object.put("msg", "开启失败,请重试");
		return object;
	}
	
	@Override
	public JSONObject useBike(String shareId,String telePhone) {
		HbShare share = this.hbShareMapper.selectByPrimaryKey(shareId);
		HbUser user = this.hbUserMapper.selectByPhone(telePhone);
		JSONObject object = new JSONObject();
		object.put("code","400");
		if (share == null) {
			object.put("msg", "车牌号不正确");
			return object;
		}
		System.out.println(share.getShare_status()+"5555555555555555555555");
		if (share.getShare_status()!=null && share.getShare_status().equals("1")) {
			object.put("msg", "该车辆尚在使用中");
			return object;
		}
		HbUserCash cash = hbUserCashMapper.selectByPrimaryKey(user.getUserId());
		if(cash==null || cash.getUserCashStatus().equals("2") || cash.getUserCashType().equals("3")){
			object.put("msg", "请缴纳押金");
			return object;
		}
		HbAccount account = this.hbAccountMapper.selectByUserId(user.getUserId());
		if(Double.parseDouble(account.getAccountTotel())<0){
			object.put("msg", "开启失败,余额不足");
			return object;
		}
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		HbJourney journey = new HbJourney();
		journey.setJourneyId(UUID.randomUUID().toString().replace("-", ""));
		journey.setJourneyShareid(shareId);
		journey.setJourneyUserid(user.getUserId());
		try {
			journey.setJourneyCreatetime(format.parse(format.format(new Date())));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		journey.setJourneyStartpot(share.getSharePot());
		int i = this.hbJourneyMapper.insertSelective(journey);
		if(i>0){
			hbShareMapper.updateStatusAndUserByid("1",user.getUserId(),shareId);
			object.put("msg", "使用成功");
			object.put("code","200");
			return object;
		}
		object.put("msg", "开启失败,请重试");
		return object;
	}
	@Override
	public JSONObject endUseBike(String shareId,String pot) {
		System.out.println("11111111111"+shareId);
		HbShare share = this.hbShareMapper.selectByPrimaryKey(shareId);
		share.setSharePot(pot);
		this.hbShareMapper.updateByPrimaryKeySelective(share);
		
		HbAccount account = this.hbAccountMapper.selectByUserId(share.getShare_userid());
		
		JSONObject object = new JSONObject();
		HbJourney journey = this.hbJourneyMapper.selectByShareId(shareId);
		long startDate = journey.getJourneyCreatetime().getTime();
		long endDate = new Date().getTime();
		long time = endDate-startDate;
		long string = time/60000;
		if(time%60000!=0){
			string=string+1;
		}
		SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		DecimalFormat    df   = new DecimalFormat("######0");
		String minute = df.format(string);
		//60分钟起步，1元。超出每30分钟收费0.6，不足按30分钟
		int j = Integer.parseInt(minute);
//		HbDetail detail1 = this.hbDetailMapper.selectByMinute(60);
		List<HbDetail> lis = this.hbDetailMapper.selectByExample(null);
		HbDetail detail1 = lis.get(0);
		journey.setJourneyTime(j);
		if(j<=detail1.getDetailMinute()){
			journey.setJourneyMoney(detail1.getDetailMoney());
		}else{
			HbDetail detail2 = lis.get(1);
			Integer timef=(j-detail1.getDetailMinute())/detail2.getDetailMinute();
			journey.setJourneyMoney(timef*detail2.getDetailMoney()+detail1.getDetailMoney());
		}
		HbShare s = new HbShare();
		s.setSharePot(journey.getJourneyStartpot());
		System.out.println(pot+"------------------");
		String[] split = pot.split(",");
		System.out.println(split.length+"------------------");
		double d = LatAndLntUtils.latAndLnt(s, split[0], split[1]);
		journey.setJourneyDistance(d);
		journey.setJourneyEndpot(pot);
		try {
			journey.setJourneyEndtime(format2.parse(format2.format(new Date(endDate))));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		int i = this.hbJourneyMapper.updateByPrimaryKeySelective(journey);
		if(i>0){
			hbShareMapper.updateStatusAndUserByid(null,null,shareId);
			account.setAccountTotel(String.valueOf(Double.parseDouble(account.getAccountTotel())-journey.getJourneyMoney()));
			this.hbAccountMapper.updateByPrimaryKey(account);
			object.put("code", "200");
			object.put("msg", "结束用车成功");
			return object;
		}
		object.put("code", "400");
		object.put("msg", "结束用车失败");
		return object;
	}
	
	
	
	@Override
	public JSONObject getUseBike(String telePhone) {
		HbUser user = this.hbUserMapper.selectByPhone(telePhone);
		HbJourney journey = (HbJourney) this.hbJourneyMapper.findByUserIdUse(user.getUserId());
		JSONObject object = new JSONObject();
		if(journey!=null) {
			object.put("code", "200");
			object.put("msg", "");
			JSONObject data = new JSONObject();
			data.put("startime", journey.getJourneyCreatetime().toString());
			object.put("data", data);
		}
		else {
			object.put("code", "100");
			object.put("msg", "查询为空");
			object.put("data", "");
		}
		return object;
	}
}
