package com.keboda.eomsback.finance.mapper;

import com.keboda.eomsback.entity.SearchVo;
import com.keboda.eomsback.finance.pojo.OmfFile;
import com.keboda.eomsback.finance.pojo.RpaVo;

import java.util.List;

public interface OmfFileMapper {
    int insertSelective(OmfFile record);
    int updateByPrimaryKeySelective(OmfFile record);

    RpaVo selectOmfByRpa(SearchVo searchVo);

    List<OmfFile> selectMaterialNum(SearchVo searchVo);
}