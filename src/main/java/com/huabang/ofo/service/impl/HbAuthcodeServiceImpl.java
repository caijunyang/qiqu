package com.huabang.ofo.service.impl;

import java.text.DateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.huabang.ofo.dao.HbAuthcodeMapper;
import com.huabang.ofo.dao.HbCashmoneysMapper;
import com.huabang.ofo.domain.HbAuthcode;
import com.huabang.ofo.service.HbAuthcodeService;
@Service
@Transactional
public class HbAuthcodeServiceImpl implements HbAuthcodeService {

	@Autowired
	private HbAuthcodeMapper hbAuthcodeMapper;
	
	@Override
	public Integer findTelephone(String telephone) {
		return hbAuthcodeMapper.findTelephone(telephone);
	}

	@Override
	public void addCode(String telephone, String checkcode,long time) {
		hbAuthcodeMapper.addCode( telephone,  checkcode,time);
	}

	@Override
	public void updateCode(String telephone, String checkcode,long time) {
		hbAuthcodeMapper.updateCode( telephone,  checkcode,time);
	}

	@Override
	public HbAuthcode selectByTelephone(String telephone) {
		return hbAuthcodeMapper.selectByTelephone( telephone);
	}

	@Transactional
	@Override
	public void delBytime(long format) {
		hbAuthcodeMapper.delBytime( format);
	}

}
