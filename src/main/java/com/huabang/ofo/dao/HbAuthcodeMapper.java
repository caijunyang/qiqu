package com.huabang.ofo.dao;

import org.apache.ibatis.annotations.Param;

import com.huabang.ofo.domain.HbAuthcode;

public interface HbAuthcodeMapper {

	Integer findTelephone(@Param("telephone")String telephone);

	void addCode(@Param("telephone")String telephone,@Param("authcode") String checkcode,@Param("time")long time);

	void updateCode(@Param("telephone")String telephone, @Param("authcode")String checkcode,@Param("time")long time);

	HbAuthcode selectByTelephone(@Param("telephone")String telephone);

	void delBytime(@Param("datetime")long format);

}
