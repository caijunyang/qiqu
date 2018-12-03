package com.huabang.ofo.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.huabang.ofo.dao.HbMessagesMapper;
import com.huabang.ofo.domain.HbMessage;
import com.huabang.ofo.service.MessagesService;

@Service
@Transactional(propagation=Propagation.REQUIRED,readOnly=true)
public class MessagesServiceImpl implements MessagesService	{

	@Autowired
	private HbMessagesMapper hbMessageMapper;
	
	@Override
	public String selectAllMessage(String messageId) {
		HbMessage list = this.hbMessageMapper.selectByPrimaryKey(Integer.parseInt(messageId));
		String string = list.getMessJbdetails();
		String[] split = string.split("&");
		Map<String,Object> map = new HashMap<>();
		map.put("mess_name", list.getMessName());
		map.put("mess_message", list.getMessMessage());
		map.put("mess_details", list.getMessDetails());
		map.put("mess_police", list.getMessPolice());
		map.put("mess_police_phone", list.getMessPolicePhone());
		map.put("mess_user_name", split[0]);
		map.put("mess_sex_age", split[1]);
		map.put("mess_address", split[2]);
		map.put("mess_time", split[3]);
		map.put("mess_birthday", split[4]);
		map.put("mess_height", split[5]);
		map.put("mess_toufa", split[6]);
		JSONObject object = new JSONObject();
		object.put("data", map);
		object.put("code", "200");
		return object.toJSONString();
	}

	@Override
	public String selectSimmpleMessage() {
		JSONObject object  =new JSONObject();
		object.put("code","200");
		List<HbMessage> list = this.hbMessageMapper.selectBySimmple();
		List<Map<String,Object>> list2 = new ArrayList<Map<String,Object>>();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		for (HbMessage hbMessage : list) {
			String date = format.format(hbMessage.getMessCreatetime());
			HashMap<String,Object> map = new HashMap<>();
			map.put("messCreatetime",date);
			map.put("messId",hbMessage.getMessId());
			map.put("messName",hbMessage.getMessName());
			map.put("messSimpleness",hbMessage.getMessSimpleness());
			list2.add(map);
		}
		object.put("data", list2);
		return object.toJSONString();
	}

}
