package com.keboda.eomsback.purchase.service;

import com.github.pagehelper.Page;
import com.keboda.eomsback.entity.SearchVo;
import com.keboda.eomsback.purchase.pojo.PmkFile;

public interface IPmkService {
    Page<PmkFile> searchListPageHelper(SearchVo searchVo);
}
