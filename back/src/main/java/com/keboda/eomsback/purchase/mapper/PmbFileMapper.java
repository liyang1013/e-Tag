package com.keboda.eomsback.purchase.mapper;

import com.keboda.eomsback.purchase.pojo.PmbFile;
import com.keboda.eomsback.purchase.pojo.PmbFileKey;

public interface PmbFileMapper {
    int insertSelective(PmbFile record);
    int updateByPrimaryKeySelective(PmbFile record);
}