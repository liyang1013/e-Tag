package com.keboda.eomsback.system.service;

import com.keboda.eomsback.entity.SearchVo;
import com.keboda.eomsback.system.pojo.PjaFile;
import java.util.List;

public interface IPjaService {
    List<PjaFile> searchPjaList(SearchVo searchVo);

    PjaFile searchPjaByKey(SearchVo searchVo);
}
