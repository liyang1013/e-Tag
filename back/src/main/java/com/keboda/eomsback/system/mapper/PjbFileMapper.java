package com.keboda.eomsback.system.mapper;

import com.keboda.eomsback.entity.SearchVo;
import com.keboda.eomsback.system.pojo.PjbFile;
import com.keboda.eomsback.system.pojo.PjbFileKey;

import java.util.List;

public interface PjbFileMapper {

    int insertSelective(PjbFile record);

    int updateByPrimaryKeySelective(PjbFile record);

    PjbFile searchPjbByKey(SearchVo searchVo);

    List<PjbFile> searchPjbList(SearchVo searchVo);
}