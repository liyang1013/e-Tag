package com.keboda.eomsback.produce.service;

import com.github.pagehelper.Page;
import com.keboda.eomsback.entity.SearchVo;
import com.keboda.eomsback.produce.pojo.SfpFile;
import com.keboda.eomsback.produce.pojo.SfsFile;

import java.util.List;

public interface ISfpService {
    Page<SfpFile> searchListPageHelper(SearchVo searchVo);

    List<SfsFile> searchSlaveList(SearchVo searchVo);

    void updateState(SfpFile sfpFile);

    void updateUnit(SfsFile sfsFile);

    void updateDate(SfpFile sfpFile);
}

