package com.bootdo.ofo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bootdo.ofo.domain.HbShare;
import com.bootdo.ofo.domain.HbShareExample;

public interface HbShareMapper {
    int countByExample(HbShareExample example);

    int deleteByExample(HbShareExample example);

    int deleteByPrimaryKey(String shareId);

    int insert(HbShare record);

    int insertSelective(HbShare record);

    List<HbShare> selectByExample(HbShareExample example);

    HbShare selectByPrimaryKey(String shareId);

    int updateByExampleSelective(@Param("record") HbShare record, @Param("example") HbShareExample example);

    int updateByExample(@Param("record") HbShare record, @Param("example") HbShareExample example);

    int updateByPrimaryKeySelective(HbShare record);

    int updateByPrimaryKey(HbShare record);
}