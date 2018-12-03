package com.bootdo.ofo.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import com.bootdo.ofo.domain.HbOrder;
import com.bootdo.ofo.domain.HbOrderExample;

public interface HbOrderMapper {
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
    
	List<Map<String,Object>> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int remove(String id);
	
	int batchRemove(String[] ids);
}