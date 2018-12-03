package com.bootdo.ofo.dao;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.bootdo.ofo.domain.HbMessage;
import com.bootdo.ofo.domain.HbMessageExample;

public interface HbMessageMapper {
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
	
	HbMessage get(Integer id);
	
	List<HbMessage> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int remove(Integer id);

	int batchRemove(Integer[] ids);
}