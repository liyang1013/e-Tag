package com.keboda.eomsback.produce.mapper;

import com.keboda.eomsback.entity.SearchVo;
import com.keboda.eomsback.produce.pojo.SfaFile;

import java.util.List;

public interface SfaFileMapper {
    List<SfaFile> searchSfaList(SearchVo searchVo);
}
