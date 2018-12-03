package com.bootdo.blog.dao;

import java.util.List;
import java.util.Map;

import com.bootdo.blog.domain.Discover;

public interface DiscoverMapper {

	Discover get(String cid);

	List<Discover> list(Map<String, Object> map);

	int count(Map<String, Object> map);

	int save(Discover bContent);

	int remove(String cid);

	int update(Discover bContent);

	int batchRemove(String[] cids);
     
	
}