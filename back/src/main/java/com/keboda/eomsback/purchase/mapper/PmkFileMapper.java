package com.keboda.eomsback.purchase.mapper;

import com.github.pagehelper.Page;
import com.keboda.eomsback.entity.SearchVo;
import com.keboda.eomsback.purchase.pojo.PmkFile;
import org.apache.ibatis.annotations.Param;

public interface PmkFileMapper {

    int insertSelective(PmkFile record);

    int updateByPrimaryKeySelective(PmkFile record);

    void InvalidDocumentDelete(@Param("centre") String centre);

    Page<PmkFile> searchListPageHelper(SearchVo searchVo);
}