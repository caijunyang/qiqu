package com.bootdo.ofo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bootdo.ofo.dao.HbPaymoneyMapper;
import com.bootdo.ofo.domain.HbPaymoney;
import com.bootdo.ofo.service.MoneyService;

@Service
@Transactional(propagation=Propagation.REQUIRED)
public class MoneyServiceImpl implements MoneyService {
	
	@Autowired
	private HbPaymoneyMapper hbPaymoneyMapper;

	@Override
	@Transactional(propagation=Propagation.REQUIRED,readOnly=true)
	public List<HbPaymoney> searchMoney() {
		List<HbPaymoney> list = this.hbPaymoneyMapper.selectByExample(null);
		return list;
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED,readOnly=true)
	public HbPaymoney get(Integer id) {
		return this.hbPaymoneyMapper.selectByPrimaryKey(id);
	}

	@Override
	public int remove(Integer id) {
		return this.hbPaymoneyMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int save(HbPaymoney pay) {
		return this.hbPaymoneyMapper.insertSelective(pay);
	}

	@Override
	public int update(HbPaymoney pay) {
		return this.hbPaymoneyMapper.updateByPrimaryKeySelective(pay);
	}

	@Override
	public int batchremove(Integer[] ids) {
		return this.hbPaymoneyMapper.batchRemove(ids);
	}

}
