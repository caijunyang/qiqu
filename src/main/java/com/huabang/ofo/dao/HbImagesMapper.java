package com.huabang.ofo.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.huabang.ofo.domain.HbImage;
import com.huabang.ofo.domain.HbImageExample;

public interface HbImagesMapper {
    int countByExample(HbImageExample example);

    int deleteByExample(HbImageExample example);

    int deleteByPrimaryKey(Integer imageId);

    int insert(HbImage record);

    int insertSelective(HbImage record);

    List<HbImage> selectByExample(HbImageExample example);

    HbImage selectByPrimaryKey(Integer imageId);

    int updateByExampleSelective(@Param("record") HbImage record, @Param("example") HbImageExample example);

    int updateByExample(@Param("record") HbImage record, @Param("example") HbImageExample example);

    int updateByPrimaryKeySelective(HbImage record);

    int updateByPrimaryKey(HbImage record);
}