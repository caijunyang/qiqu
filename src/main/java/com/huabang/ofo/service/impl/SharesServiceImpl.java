package com.huabang.ofo.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.huabang.ofo.dao.HbSharesMapper;
import com.huabang.ofo.domain.HbShare;
import com.huabang.ofo.service.SharesService;
import com.huabang.ofo.utils.LatAndLntUtils;

@Service
@Transactional(propagation=Propagation.REQUIRED,readOnly=true)
public class SharesServiceImpl implements SharesService {

	@Autowired
	private HbSharesMapper hbShareMapper;
	
	@Override
	public String selectShareAll(String lat,String lng) {
		List<HbShare> list = this.hbShareMapper.selectByExample(null);
		List<HbShare> li = new ArrayList<HbShare>();
		for (HbShare hbShare : list) {
			double km = LatAndLntUtils.latAndLnt(hbShare, lat, lng);
			if(km<1.00){
				li.add(hbShare);
			}
		}
		JSONObject object = new JSONObject();
		object.put("list", li);
		return object.toJSONString();
	}

}
