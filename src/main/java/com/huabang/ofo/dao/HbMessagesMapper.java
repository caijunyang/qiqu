package com.huabang.ofo.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.huabang.ofo.domain.HbMessage;
import com.huabang.ofo.domain.HbMessageExample;

public interface HbMessagesMapper {
    int countByExample(HbMessageExample example);

    int deleteByExample(HbMessageExample example);

    int deleteByPrimaryKey(Integer messId);

    int insert(HbMessage record);

    int insertSelective(HbMessage record);

    List<HbMessage> selectByExample(HbMessageExample example);

    HbMessage selectByPrimaryKey(Integer messId);

    int updateByExampleSelective(@Param("record") HbMessage record, @Param("example") HbMessageExample example);

    int updateByExample(@Param("record") HbMessage record, @Param("example") HbMessageExample example);

    int updateByPrimaryKeySelective(HbMessage record);

    int updateByPrimaryKey(HbMessage record);

	List<HbMessage> selectBySimmple();
}