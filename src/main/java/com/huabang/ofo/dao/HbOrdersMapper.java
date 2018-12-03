package com.huabang.ofo.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.huabang.ofo.domain.HbOrder;
import com.huabang.ofo.domain.HbOrderExample;

public interface HbOrdersMapper {
    int countByExample(HbOrderExample example);

    int deleteByExample(HbOrderExample example);

    int deleteByPrimaryKey(String orderId);

    int insert(HbOrder record);

    int insertSelective(HbOrder record);

    List<HbOrder> selectByExample(HbOrderExample example);

    HbOrder selectByPrimaryKey(String orderId);

    int updateByExampleSelective(@Param("record") HbOrder record, @Param("example") HbOrderExample example);

    int updateByExample(@Param("record") HbOrder record, @Param("example") HbOrderExample example);

    int updateByPrimaryKeySelective(HbOrder record);

    int updateByPrimaryKey(HbOrder record);

	ArrayList<HbOrder> findByUserid(String userid);

	void updateStatus(@Param("orderid")String parameter, @Param("status")String string);

	ArrayList<HbOrder> findByUserid2(String userid);
}