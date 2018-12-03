package com.bootdo.ofo.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bootdo.common.domain.PageDO;
import com.bootdo.common.utils.Query;
import com.bootdo.ofo.dao.HbJourneyMapper;
import com.bootdo.ofo.service.XingCheService;

@Service
@Transactional(propagation=Propagation.REQUIRED)
public class XingCheServiceImpl implements XingCheService {
	@Autowired
	private HbJourneyMapper hbJourneyMapper;

	@Override
	@Transactional(propagation=Propagation.REQUIRED,readOnly=true)
	public PageDO<Map<String, Object>> queryList(Query query) {
		int total = hbJourneyMapper.count(query);
		List<Map<String, Object>> logs = hbJourneyMapper.list(query);
		PageDO<Map<String, Object>> page = new PageDO<>();
		page.setTotal(total);
		page.setRows(logs);
		return page;
	}

	@Override
	public int remove(String id) {
		int count = hbJourneyMapper.deleteByPrimaryKey(id);
		return count;
	}

	@Override
	public int batchRemove(String[] ids){
		return hbJourneyMapper.batchRemove(ids);
	}
}
