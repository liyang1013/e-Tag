package com.keboda.eomsback.system.service;

import com.keboda.eomsback.entity.SearchVo;
import com.keboda.eomsback.system.pojo.GfeFile;

import java.util.List;

public interface IGfeService {
    List<GfeFile> searchGfeList(SearchVo searchVo);

    GfeFile searchGfeByKey(SearchVo searchVo);
}
