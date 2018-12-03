package com.huabang.ofo.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONObject;
import com.bootdo.ofo.dao.HbUserMapper;
import com.bootdo.ofo.domain.HbUser;
import com.huabang.ofo.dao.HbJourneysMapper;
import com.huabang.ofo.domain.HbJourney;
import com.huabang.ofo.service.JourneyService;

@Service
@Transactional(propagation=Propagation.REQUIRED,readOnly=true)
public class JourneyServiceImpl implements JourneyService {

	@Autowired
	private HbJourneysMapper hbJourneyMapper;
	@Autowired
	private HbUserMapper hbuserMapper;
	
	@Override
	public String selectJourney(String phone) {
		HbUser user = this.hbuserMapper.selectByPhone(phone);
		List<HbJourney> hbJourney = hbJourneyMapper.selectByPhone(user.getUserId());
		JSONObject object = new JSONObject();
		object.put("list", hbJourney);
		return object.toJSONString();
	}

	@Override
	public String selectById(String journeyId) {
		Map<String, Object> journey = this.hbJourneyMapper.selectByKey(journeyId);
		JSONObject object = new JSONObject();
		object.put("list", journey);
		return object.toJSONString();
	}

}
