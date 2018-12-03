package com.bootdo.blog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import com.bootdo.blog.dao.DiscoverMapper;
import com.bootdo.blog.domain.Discover;
import com.bootdo.blog.service.ContentService;



@Service
@Transactional(propagation=Propagation.REQUIRED)
public class ContentServiceImpl implements ContentService {
	@Autowired
	private DiscoverMapper bContentMapper;
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED,readOnly=true)
	public Discover get(String cid){
		return bContentMapper.get(cid);
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED,readOnly=true)
	public List<Discover> list(Map<String, Object> map){
		return bContentMapper.list(map);
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED,readOnly=true)
	public int count(Map<String, Object> map){
		return bContentMapper.count(map);
	}
	
	@Override
	public int save(Discover bContent){
		return bContentMapper.save(bContent);
	}
	
	@Override
	public int update(Discover bContent){
		return bContentMapper.update(bContent);
	}
	
	@Override
	public int remove(String cid){
		return bContentMapper.remove(cid);
	}
	
	@Override
	public int batchRemove(String[] cids){
		return bContentMapper.batchRemove(cids);
	}
	
}
