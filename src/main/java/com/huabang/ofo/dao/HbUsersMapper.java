package com.huabang.ofo.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.huabang.ofo.domain.HbUser;
import com.huabang.ofo.domain.HbUserExample;

public interface HbUsersMapper {
    int countByExample(HbUserExample example);

    int deleteByExample(HbUserExample example);

    int deleteByPrimaryKey(String userId);

    int insert(HbUser record);

    int insertSelective(HbUser record);

    List<HbUser> selectByExample(HbUserExample example);

    HbUser selectByPrimaryKey(String userId);
    
	HbUser selectByPhone(String telephone);

    int updateByExampleSelective(@Param("record") HbUser record, @Param("example") HbUserExample example);

    int updateByExample(@Param("record") HbUser record, @Param("example") HbUserExample example);

    int updateByPrimaryKeySelective(HbUser record);

    int updateByPrimaryKey(HbUser record);

}