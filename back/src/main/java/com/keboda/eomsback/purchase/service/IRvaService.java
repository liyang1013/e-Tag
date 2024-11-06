package com.keboda.eomsback.purchase.service;

import com.github.pagehelper.Page;
import com.keboda.eomsback.entity.SearchVo;
import com.keboda.eomsback.purchase.pojo.RvaFile;
import com.keboda.eomsback.purchase.pojo.RvbFile;

import java.util.List;

public interface IRvaService {
    Page<RvaFile> searchListPageHelper(SearchVo searchVo);

    void updateConf(RvaFile rvaFile);

    void updateDate(RvaFile rvaFile);
}
