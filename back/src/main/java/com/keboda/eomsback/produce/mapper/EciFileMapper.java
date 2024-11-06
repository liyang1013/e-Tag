package com.keboda.eomsback.produce.mapper;

import com.keboda.eomsback.entity.SearchVo;
import com.keboda.eomsback.produce.pojo.EciFile;

import java.util.List;

public interface EciFileMapper {

    int insertSelective(EciFile record);


    int updateByPrimaryKeySelective(EciFile record);

    List<EciFile> searchEciList(SearchVo searchVo);

    EciFile searchEciByKey(SearchVo searchVo);
}