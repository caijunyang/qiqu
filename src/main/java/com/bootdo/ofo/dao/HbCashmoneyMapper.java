package com.bootdo.ofo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bootdo.ofo.domain.HbCashmoney;
import com.bootdo.ofo.domain.HbCashmoneyExample;

public interface HbCashmoneyMapper {
    int countByExample(HbCashmoneyExample example);

    int deleteByExample(HbCashmoneyExample example);

    int deleteByPrimaryKey(Integer cashId);

    int insert(HbCashmoney record);

    int insertSelective(HbCashmoney record);

    List<HbCashmoney> selectByExample(HbCashmoneyExample example);

    HbCashmoney selectByPrimaryKey(Integer cashId);

    int updateByExampleSelective(@Param("record") HbCashmoney record, @Param("example") HbCashmoneyExample example);

    int updateByExample(@Param("record") HbCashmoney record, @Param("example") HbCashmoneyExample example);

    int updateByPrimaryKeySelective(HbCashmoney record);

    int updateByPrimaryKey(HbCashmoney record);

	int batchRemove(Integer[] ids);
}