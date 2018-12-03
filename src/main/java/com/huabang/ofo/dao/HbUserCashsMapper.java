package com.huabang.ofo.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.huabang.ofo.domain.HbUserCash;
import com.huabang.ofo.domain.HbUserCashExample;

public interface HbUserCashsMapper {
    int countByExample(HbUserCashExample example);

    int deleteByExample(HbUserCashExample example);

    int deleteByPrimaryKey(String userId);

    int insert(HbUserCash record);

    int insertSelective(HbUserCash record);

    List<HbUserCash> selectByExample(HbUserCashExample example);

    HbUserCash selectByPrimaryKey(String userId);

    int updateByExampleSelective(@Param("record") HbUserCash record, @Param("example") HbUserCashExample example);

    int updateByExample(@Param("record") HbUserCash record, @Param("example") HbUserCashExample example);

    int updateByPrimaryKeySelective(HbUserCash record);

    int updateByPrimaryKey(HbUserCash record);

	HbUserCash selectByPrimaryKey2(String userId);
}