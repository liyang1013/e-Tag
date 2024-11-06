package com.keboda.eomsback.system.mapper;

import com.keboda.eomsback.entity.SearchVo;
import com.keboda.eomsback.system.pojo.PjaFile;

import java.util.List;

public interface PjaFileMapper {

    int insertSelective(PjaFile record);

    int updateByPrimaryKeySelective(PjaFile record);

    List<PjaFile> searchPjaList(SearchVo searchVo);

    PjaFile searchPjaByKey(SearchVo searchVo);
}