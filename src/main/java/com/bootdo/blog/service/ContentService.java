package com.bootdo.blog.service;

import com.bootdo.blog.domain.Discover;
import com.bootdo.blog.domain.Discover;

import java.util.List;
import java.util.Map;

/**
 * 文章内容
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2017-09-09 10:03:34
 */
public interface ContentService {
	
	Discover get(String discoverId);
	
	List<Discover> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(Discover bContent);
	
	int update(Discover bContent);
	
	int remove(String cid);
	
	int batchRemove(String[] cids);
}
