package com.keboda.eomsback.system.mapper;

import com.keboda.eomsback.system.pojo.SmaFile;
import org.apache.ibatis.annotations.Param;

public interface SmaFileMapper {

    SmaFile select(@Param("centre") String centre);
}
