package com.keboda.eomsback.system.mapper;

import com.keboda.eomsback.entity.SearchVo;
import com.keboda.eomsback.system.pojo.GfeFile;

import java.util.List;

public interface GfeFileMapper {

    int insertSelective(GfeFile record);

    int updateByPrimaryKeySelective(GfeFile record);

    GfeFile searchGfeByKey(SearchVo searchVo);

    List<GfeFile> searchGfeList(SearchVo searchVo);
}