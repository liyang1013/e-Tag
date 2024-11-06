package com.keboda.eomsback.purchase.mapper;

import com.github.pagehelper.Page;
import com.keboda.eomsback.entity.SearchVo;
import com.keboda.eomsback.purchase.pojo.PmaFile;

public interface PmaFileMapper {

    int insertSelective(PmaFile record);

    int updateByPrimaryKeySelective(PmaFile record);

    Page<PmaFile> searchListPageHelper(SearchVo searchVo);
}