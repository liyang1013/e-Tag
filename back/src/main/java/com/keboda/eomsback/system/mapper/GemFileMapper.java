package com.keboda.eomsback.system.mapper;

import com.keboda.eomsback.entity.SearchVo;
import com.keboda.eomsback.system.pojo.GemFile;

import java.util.List;

public interface GemFileMapper {

    List<GemFile> searchGemList(SearchVo searchVo);

    GemFile searchGemByKey(SearchVo searchVo);
}