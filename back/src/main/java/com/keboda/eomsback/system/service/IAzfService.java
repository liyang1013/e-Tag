package com.keboda.eomsback.system.service;

import com.keboda.eomsback.entity.SearchVo;
import com.keboda.eomsback.system.pojo.AzfFile;

import java.util.List;

public interface IAzfService {
    List<AzfFile> searchAzfList(SearchVo searchVo);

    AzfFile searchAzfByKey(SearchVo searchVo);
}
