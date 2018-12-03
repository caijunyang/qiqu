package com.huabang.ofo.service;

import com.huabang.ofo.domain.HbAuthcode;

public interface HbAuthcodeService {

	Integer findTelephone(String telephone);

	void addCode(String telephone, String checkcode,long time);

	void updateCode(String telephone, String checkcode,long time);

	HbAuthcode selectByTelephone(String telephone);

	void delBytime(long format);

}
