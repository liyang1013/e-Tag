package com.keboda.eomsback.system.service;

import com.keboda.eomsback.entity.SearchVo;
import com.keboda.eomsback.system.pojo.PjbFile;

import java.util.List;

public interface IPjbService {
    List<PjbFile> searchPjbList(SearchVo searchVo);

    PjbFile searchPjbByKey(SearchVo searchVo);
}
