package com.bootdo.ofo.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.bootdo.common.utils.Query;
import com.bootdo.ofo.domain.HbJourney;
import com.bootdo.ofo.domain.HbJourneyExample;

public interface HbJourneyMapper {
    int countByExample(HbJourneyExample example);

    int deleteByExample(HbJourneyExample example);

    int deleteByPrimaryKey(String journeyId);

    int insert(HbJourney record);

    int insertSelective(HbJourney record);

    List<HbJourney> selectByExample(HbJourneyExample example);

    HbJourney selectByPrimaryKey(String journeyId);

    int updateByExampleSelective(@Param("record") HbJourney record, @Param("example") HbJourneyExample example);

    int updateByExample(@Param("record") HbJourney record, @Param("example") HbJourneyExample example);

    int updateByPrimaryKeySelective(HbJourney record);

    int updateByPrimaryKey(HbJourney record);

	List<HbJourney> selectByPhone(String phone);

	HbJourney selectByShareId(String shareId);

	Map<String,Object> selectByKey(String journeyId);

	int count(Query query);

	List<Map<String, Object>> list(Query query);

	int batchRemove(String[] ids);
}