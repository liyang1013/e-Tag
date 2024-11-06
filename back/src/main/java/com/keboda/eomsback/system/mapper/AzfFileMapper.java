package com.keboda.eomsback.system.mapper;

import com.keboda.eomsback.entity.SearchVo;
import com.keboda.eomsback.system.pojo.AzfFile;

import java.util.List;

public interface AzfFileMapper {

    int insertSelective(AzfFile record);

    int updateByPrimaryKeySelective(AzfFile record);

    List<AzfFile> searchAzfList(SearchVo searchVo);

    AzfFile searchAzfByKey(SearchVo searchVo);
}