package com.keboda.eomsback.purchase.mapper;

import com.github.pagehelper.Page;
import com.keboda.eomsback.entity.SearchVo;
import com.keboda.eomsback.purchase.pojo.PmcFile;

public interface PmcFileMapper {

    int insertSelective(PmcFile record);

    int updateByPrimaryKeySelective(PmcFile record);

    Page<PmcFile> searchListPageHelper(SearchVo searchVo);
}