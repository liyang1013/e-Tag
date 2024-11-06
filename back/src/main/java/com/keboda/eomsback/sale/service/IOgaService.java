package com.keboda.eomsback.sale.service;

import com.github.pagehelper.Page;
import com.keboda.eomsback.entity.SearchVo;
import com.keboda.eomsback.purchase.pojo.RvuFile;
import com.keboda.eomsback.sale.pojo.OgaFile;
import com.keboda.eomsback.sale.pojo.OgbFile;

import java.util.List;

public interface IOgaService {
    Page<OgaFile> searchOgaListPageHelper(SearchVo searchVo);

    List<OgbFile> searchOgbList(SearchVo searchVo);

    void alterOgaDate(OgaFile ogaFile);
}
