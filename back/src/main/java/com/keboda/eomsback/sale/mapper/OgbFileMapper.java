package com.keboda.eomsback.sale.mapper;

import com.keboda.eomsback.entity.SearchVo;
import com.keboda.eomsback.sale.pojo.OgbFile;
import com.keboda.eomsback.sale.pojo.OgbFileKey;

import java.util.List;

public interface OgbFileMapper {

    int insertSelective(OgbFile record);

    int updateByPrimaryKeySelective(OgbFile record);

    List<OgbFile> searchOgbList(SearchVo searchVo);
}