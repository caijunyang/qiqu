package com.huabang.ofo.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.huabang.ofo.domain.HbSysUser;
import com.huabang.ofo.domain.HbSysUserExample;

public interface HbSysUsersMapper {
    int countByExample(HbSysUserExample example);

    int deleteByExample(HbSysUserExample example);

    int deleteByPrimaryKey(Integer sysId);

    int insert(HbSysUser record);

    int insertSelective(HbSysUser record);

    List<HbSysUser> selectByExample(HbSysUserExample example);

    HbSysUser selectByPrimaryKey(Integer sysId);

    int updateByExampleSelective(@Param("record") HbSysUser record, @Param("example") HbSysUserExample example);

    int updateByExample(@Param("record") HbSysUser record, @Param("example") HbSysUserExample example);

    int updateByPrimaryKeySelective(HbSysUser record);

    int updateByPrimaryKey(HbSysUser record);
}