package com.keboda.eomsback.stock.mapper;

import com.keboda.eomsback.stock.pojo.OblFile;
import com.keboda.eomsback.stock.pojo.OblFileKey;
import org.apache.ibatis.annotations.Param;

public interface OblFileMapper {

    int insertSelective(OblFile record);

    int updateByPrimaryKeySelective(OblFile record);
}