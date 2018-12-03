package com.huabang.ofo.dao;

import java.util.List;
import java.util.Map;

import com.huabang.ofo.domain.Discover;

public interface DiscoversMapper {

	Discover get(String cid);

	List<Discover> list();

	List<Discover> list2();
}