package com.keboda.eomsback.finance.mapper;

import com.keboda.eomsback.entity.SearchVo;
import com.keboda.eomsback.finance.pojo.OmbFile;
import com.keboda.eomsback.finance.pojo.OmbFileKey;
import com.keboda.eomsback.finance.pojo.OmfFile;
import com.keboda.eomsback.finance.pojo.RpaVo;

import java.util.List;

public interface OmbFileMapper {

    int insertSelective(OmbFile record);

    int updateByPrimaryKeySelective(OmbFile record);

    RpaVo selectOmbByRpa(SearchVo searchVo);

    List<OmbFile> selectMaterialNum(SearchVo searchVo);
}