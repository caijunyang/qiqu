package com.bootdo.ofo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bootdo.ofo.dao.HbDetailMapper;
import com.bootdo.ofo.domain.HbDetail;
import com.bootdo.ofo.service.DetailService;

@Service
@Transactional(propagation=Propagation.REQUIRED)
public class DetailServiceImpl implements DetailService {
	
	@Autowired
	private HbDetailMapper HbDetailMapper;

	@Override
	@Transactional(propagation=Propagation.REQUIRED,readOnly=true)
	public List<HbDetail> searchMoney() {
		List<HbDetail> list = this.HbDetailMapper.selectByExample(null);
		return list;
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED,readOnly=true)
	public HbDetail get(Integer id) {
		return this.HbDetailMapper.selectByPrimaryKey(id);
	}

	@Override
	public int remove(Integer id) {
		return this.HbDetailMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int save(HbDetail pay) {
		return this.HbDetailMapper.insertSelective(pay);
	}

	@Override
	public int update(HbDetail pay) {
		return this.HbDetailMapper.updateByPrimaryKeySelective(pay);
	}

	@Override
	public int batchremove(Integer[] ids) {
		return this.HbDetailMapper.batchRemove(ids);
	}

}
