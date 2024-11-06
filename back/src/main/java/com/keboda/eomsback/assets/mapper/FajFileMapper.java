package com.keboda.eomsback.assets.mapper;

import com.keboda.eomsback.assets.pojo.FajFile;
import com.keboda.eomsback.assets.pojo.FajFileKey;

public interface FajFileMapper {
    int insertSelective(FajFile record);

    int updateByPrimaryKeySelective(FajFile record);

}