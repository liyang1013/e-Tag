package com.keboda.eomsback.produce.service;

import com.github.pagehelper.Page;
import com.keboda.eomsback.entity.SearchVo;
import com.keboda.eomsback.produce.pojo.SfuFile;
import com.keboda.eomsback.produce.pojo.SfvFile;

import java.util.List;

public interface ISfuService {
    Page<SfuFile> searchSfuListPageHelper(SearchVo searchVo);

    List<SfvFile> searchSfvList(SearchVo searchVo);

    void updateState(SfuFile sfuFile);

    void updateDate(SfuFile sfuFile);
}
