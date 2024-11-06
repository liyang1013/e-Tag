package com.keboda.eomsback.produce.mapper;

import com.keboda.eomsback.produce.pojo.EcmFile;
import com.keboda.eomsback.produce.pojo.EcmFileKey;

public interface EcmFileMapper {

    int insertSelective(EcmFile record);

    int updateByPrimaryKeySelective(EcmFile record);
}