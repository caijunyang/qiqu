package com.huabang.ofo.dao;

import com.huabang.ofo.domain.HbDetail;
import com.huabang.ofo.domain.HbDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HbDetailsMapper {
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
}