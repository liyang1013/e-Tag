package com.keboda.eomsback.purchase.service;

import com.github.pagehelper.Page;
import com.keboda.eomsback.entity.SearchVo;
import com.keboda.eomsback.purchase.pojo.PmcFile;
import com.keboda.eomsback.purchase.pojo.PmyFile;

public interface IPmcService {
    Page<PmcFile> searchListPageHelper(SearchVo searchVo);
}
