package com.bootdo.ofo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bootdo.ofo.domain.HbUser;

@Service
public interface UService {

	HbUser get(String id);

	List<HbUser> list();

	int save(HbUser role);

	int update(HbUser role);

	int remove(String id);

	HbUser list(String userId);

	int batchremove(String[] ids);

	List<HbUser> list2();
}
