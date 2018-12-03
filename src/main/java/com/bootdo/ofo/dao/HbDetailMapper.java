package com.bootdo.ofo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bootdo.ofo.domain.HbDetail;
import com.bootdo.ofo.domain.HbDetailExample;

public interface HbDetailMapper {
    int countByExample(HbDetailExample example);

    int deleteByExample(HbDetailExample example);

    int deleteByPrimaryKey(Integer detailId);

    int insert(HbDetail record);

    int insertSelective(HbDetail record);

    List<HbDetail> selectByExample(HbDetailExample example);

    HbDetail selectByPrimaryKey(Integer detailId);

    int updateByExampleSelective(@Param("record") HbDetail record, @Param("example") HbDetailExample example);

    int updateByExample(@Param("record") HbDetail record, @Param("example") HbDetailExample example);

    int updateByPrimaryKeySelective(HbDetail record);

    int updateByPrimaryKey(HbDetail record);

	HbDetail selectByMinute(int minute);

	int batchRemove(Integer[] ids);
}