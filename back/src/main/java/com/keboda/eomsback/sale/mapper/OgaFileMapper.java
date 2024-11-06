package com.keboda.eomsback.sale.mapper;

import com.github.pagehelper.Page;
import com.keboda.eomsback.entity.SearchVo;
import com.keboda.eomsback.purchase.pojo.RvuFile;
import com.keboda.eomsback.sale.pojo.OgaFile;

public interface OgaFileMapper {

    int insertSelective(OgaFile record);

    int updateByPrimaryKeySelective(OgaFile record);

    Page<OgaFile> searchOgaListPageHelper(SearchVo searchVo);

    void alterOgaDate(OgaFile ogaFile);
}