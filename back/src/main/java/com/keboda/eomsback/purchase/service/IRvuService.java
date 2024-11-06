package com.keboda.eomsback.purchase.service;

import com.github.pagehelper.Page;
import com.keboda.eomsback.entity.SearchVo;
import com.keboda.eomsback.purchase.pojo.RvuFile;
import com.keboda.eomsback.purchase.pojo.RvvFile;

import java.util.List;

public interface IRvuService {
    Page<RvuFile> searchListPageHelper(SearchVo searchVo);

    void updateDate(RvuFile rvuFile);
}
