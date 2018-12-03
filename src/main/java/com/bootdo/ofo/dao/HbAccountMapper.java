package com.bootdo.ofo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bootdo.ofo.domain.HbAccount;
import com.bootdo.ofo.domain.HbAccountExample;

public interface HbAccountMapper {
    int countByExample(HbAccountExample example);

    int deleteByExample(HbAccountExample example);

    int deleteByPrimaryKey(Integer accountId);

    int insert(HbAccount record);

    int insertSelective(HbAccount record);

    List<HbAccount> selectByExample(HbAccountExample example);

    HbAccount selectByPrimaryKey(Integer accountId);

    int updateByExampleSelective(@Param("record") HbAccount record, @Param("example") HbAccountExample example);

    int updateByExample(@Param("record") HbAccount record, @Param("example") HbAccountExample example);

    int updateByPrimaryKeySelective(HbAccount record);

    int updateByPrimaryKey(HbAccount record);

	HbAccount selectMoney(String telephone);

	HbAccount selectByUserId(String userId);

	void batchRemove(String[] ids);

	void deleteByUserid(String string);
}