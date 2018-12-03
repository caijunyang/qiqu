package com.bootdo.ofo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bootdo.ofo.dao.HbCashmoneyMapper;
import com.bootdo.ofo.domain.HbCashmoney;
import com.bootdo.ofo.service.CashService;

@Service
@Transactional(propagation=Propagation.REQUIRED)
public class CashServiceImpl implements CashService {
	
	@Autowired
	private HbCashmoneyMapper hbCashmoneyMapper;

	@Override
	@Transactional(propagation=Propagation.REQUIRED,readOnly=true)
	public List<HbCashmoney> searchMoney() {
		List<HbCashmoney> list = this.hbCashmoneyMapper.selectByExample(null);
		return list;
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED,readOnly=true)
	public HbCashmoney get(Integer id) {
		return this.hbCashmoneyMapper.selectByPrimaryKey(id);
	}

	@Override
	public int remove(Integer id) {
		return this.hbCashmoneyMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int save(HbCashmoney pay) {
		return this.hbCashmoneyMapper.insertSelective(pay);
	}

	@Override
	public int update(HbCashmoney pay) {
		return this.hbCashmoneyMapper.updateByPrimaryKeySelective(pay);
	}

	@Override
	public int batchremove(Integer[] ids) {
		return this.hbCashmoneyMapper.batchRemove(ids);
	}

}
