package com.keboda.eomsback.purchase.service;

import com.github.pagehelper.Page;
import com.keboda.eomsback.entity.SearchVo;
import com.keboda.eomsback.purchase.pojo.PmhFile;

public interface IPmhService {
    Page<PmhFile> searchListPageHelper(SearchVo searchVo);
}
