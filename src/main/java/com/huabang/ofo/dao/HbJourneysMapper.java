package com.huabang.ofo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.huabang.ofo.domain.HbJourney;
import com.huabang.ofo.domain.HbJourneyExample;

public interface HbJourneysMapper {
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

	ArrayList<HbJourney> findByUserid(String userid);

	HbJourney findByUserIdUse(String userId);
}