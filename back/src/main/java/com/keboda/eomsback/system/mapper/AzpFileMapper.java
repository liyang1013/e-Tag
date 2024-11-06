package com.keboda.eomsback.system.mapper;

import com.keboda.eomsback.system.pojo.AzpFile;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AzpFileMapper {

    List<AzpFile> searchAzpList(@Param("azp01") String azp01);

    AzpFile selectByPrimaryKey(@Param("azp01")String azp01);
}