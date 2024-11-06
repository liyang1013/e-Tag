package com.keboda.eomsback.sale.mapper;

import com.keboda.eomsback.entity.SearchVo;
import com.keboda.eomsback.sale.pojo.OhbFile;
import com.keboda.eomsback.sale.pojo.OhbFileKey;

import java.util.List;

public interface OhbFileMapper {

    int insertSelective(OhbFile record);

    int updateByPrimaryKeySelective(OhbFile record);

    List<OhbFile> searchOhbList(SearchVo searchVo);
}