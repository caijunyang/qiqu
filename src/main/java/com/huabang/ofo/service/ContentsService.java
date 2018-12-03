package com.huabang.ofo.service;

import java.util.List;
import java.util.Map;

import com.huabang.ofo.domain.Discover;

/**
 * 文章内容
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2017-09-09 10:03:34
 */
public interface ContentsService {
	
	Discover get(String discoverId);
	
	List<Discover> list();

	List<Discover> list2();
	
}
