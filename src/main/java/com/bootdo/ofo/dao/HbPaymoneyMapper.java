package com.bootdo.ofo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bootdo.ofo.domain.HbPaymoney;
import com.bootdo.ofo.domain.HbPaymoneyExample;

public interface HbPaymoneyMapper {
    int countByExample(HbPaymoneyExample example);

    int deleteByExample(HbPaymoneyExample example);

    int deleteByPrimaryKey(Integer payId);

    int insert(HbPaymoney record);

    int insertSelective(HbPaymoney record);

    List<HbPaymoney> selectByExample(HbPaymoneyExample example);

    HbPaymoney selectByPrimaryKey(Integer payId);

    int updateByExampleSelective(@Param("record") HbPaymoney record, @Param("example") HbPaymoneyExample example);

    int updateByExample(@Param("record") HbPaymoney record, @Param("example") HbPaymoneyExample example);

    int updateByPrimaryKeySelective(HbPaymoney record);

    int updateByPrimaryKey(HbPaymoney record);

	int batchRemove(Integer[] ids);
}