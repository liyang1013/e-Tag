package com.keboda.eomsback.system.service;

import com.keboda.eomsback.entity.SearchVo;
import com.keboda.eomsback.system.pojo.GemFile;

import java.util.List;

public interface IGemService {

    List<GemFile> searchGemList(SearchVo searchVo);

    GemFile searchGemByKey(SearchVo searchVo);
}
