package com.keboda.eomsback.purchase.mapper;

import com.keboda.eomsback.entity.SearchVo;
import com.keboda.eomsback.purchase.pojo.PmlFile;
import com.keboda.eomsback.purchase.pojo.PmlFileKey;

import java.util.List;

public interface PmlFileMapper {

    int insertSelective(PmlFile record);

    int updateByPrimaryKeySelective(PmlFile record);

    List<PmlFile> searchListByOrderCode(SearchVo searchVo);
}