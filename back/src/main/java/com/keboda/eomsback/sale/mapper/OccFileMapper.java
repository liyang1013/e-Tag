package com.keboda.eomsback.sale.mapper;

import com.github.pagehelper.Page;
import com.keboda.eomsback.entity.SearchVo;
import com.keboda.eomsback.sale.pojo.OccFile;

public interface OccFileMapper {

    int insertSelective(OccFile record);

    int updateByPrimaryKeySelective(OccFile record);

    Page<OccFile> searchOccListPageHelper(SearchVo searchVo);
}