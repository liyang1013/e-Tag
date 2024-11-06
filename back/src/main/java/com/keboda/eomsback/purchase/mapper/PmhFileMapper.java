package com.keboda.eomsback.purchase.mapper;

import com.github.pagehelper.Page;
import com.keboda.eomsback.entity.SearchVo;
import com.keboda.eomsback.purchase.pojo.PmhFile;
import com.keboda.eomsback.purchase.pojo.PmhFileKey;

public interface PmhFileMapper {
    int insertSelective(PmhFile record);

    int updateByPrimaryKeySelective(PmhFile record);

    Page<PmhFile> searchListPageHelper(SearchVo searchVo);
}