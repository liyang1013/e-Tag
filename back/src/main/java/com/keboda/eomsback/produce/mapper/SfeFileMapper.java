package com.keboda.eomsback.produce.mapper;

import com.keboda.eomsback.produce.pojo.SfeFile;

public interface SfeFileMapper {
    int insertSelective(SfeFile record);
}