package com.keboda.eomsback.stock.mapper;

import com.keboda.eomsback.stock.pojo.ObkFile;
import com.keboda.eomsback.stock.pojo.ObkFileKey;
import org.apache.ibatis.annotations.Param;

public interface ObkFileMapper {

    int insertSelective(ObkFile record);

    int updateByPrimaryKeySelective(ObkFile record);
}