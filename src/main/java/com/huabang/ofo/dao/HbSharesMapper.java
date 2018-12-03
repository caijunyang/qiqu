package com.huabang.ofo.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.huabang.ofo.domain.HbShare;
import com.huabang.ofo.domain.HbShareExample;

public interface HbSharesMapper {
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

	void updateStatusAndUserByid(@Param("status")String string, @Param("userId")String userId, @Param("shareId")String shareId);

	HbShare findByUseridAndStatus(@Param("status")String userId,@Param("userid") String string);
}