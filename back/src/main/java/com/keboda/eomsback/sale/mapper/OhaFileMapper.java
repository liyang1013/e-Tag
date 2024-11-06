package com.keboda.eomsback.sale.mapper;

import com.github.pagehelper.Page;
import com.keboda.eomsback.entity.SearchVo;
import com.keboda.eomsback.sale.pojo.OhaFile;

public interface OhaFileMapper {
    int insertSelective(OhaFile record);

    int updateByPrimaryKeySelective(OhaFile record);

    Page<OhaFile> searchOhaListPageHelper(SearchVo searchVo);

    void alterOhaDate(OhaFile ohaFile);
}