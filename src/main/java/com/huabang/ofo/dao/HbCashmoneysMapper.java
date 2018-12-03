package com.huabang.ofo.dao;

import com.huabang.ofo.domain.HbCashmoney;
import com.huabang.ofo.domain.HbCashmoneyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HbCashmoneysMapper {
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
}