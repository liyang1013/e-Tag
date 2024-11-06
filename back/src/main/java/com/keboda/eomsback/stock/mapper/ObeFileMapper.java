package com.keboda.eomsback.stock.mapper;

import com.keboda.eomsback.stock.pojo.ObeFile;
import org.apache.ibatis.annotations.Param;

public interface ObeFileMapper {
    int insertSelective(ObeFile record);
    int updateByPrimaryKeySelective(ObeFile record);
}