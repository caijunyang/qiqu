package com.huabang.ofo.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.huabang.ofo.dao.DiscoversMapper;
import com.huabang.ofo.domain.Discover;
import com.huabang.ofo.service.ContentsService;

@Service
@Transactional(propagation=Propagation.REQUIRED,readOnly=true)
public class ContentsServiceImpl implements ContentsService {
	@Autowired
	private DiscoversMapper bContentMapper;
	
	@Override
	public Discover get(String cid){
		return bContentMapper.get(cid);
	}
	
	@Override
	public List<Discover> list(){
		return bContentMapper.list();
	}

	@Override
	public List<Discover> list2() {
		return bContentMapper.list2();
	}
	
}
