package com.keboda.eomsback.purchase.mapper;

import com.github.pagehelper.Page;
import com.keboda.eomsback.entity.SearchVo;
import com.keboda.eomsback.purchase.pojo.PmyFile;

public interface PmyFileMapper {

    int insertSelective(PmyFile record);

    int updateByPrimaryKeySelective(PmyFile record);
}