package com.keboda.eomsback.sale.mapper;

import com.keboda.eomsback.sale.pojo.OebFile;
import com.keboda.eomsback.sale.pojo.OebFileKey;

public interface OebFileMapper {

    int insertSelective(OebFile record);

    int updateByPrimaryKeySelective(OebFile record);
}