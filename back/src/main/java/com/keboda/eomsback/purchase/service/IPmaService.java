package com.keboda.eomsback.purchase.service;

import com.github.pagehelper.Page;
import com.keboda.eomsback.entity.SearchVo;
import com.keboda.eomsback.purchase.pojo.PmaFile;

public interface IPmaService {
    Page<PmaFile> searchListPageHelper(SearchVo searchVo);
}
