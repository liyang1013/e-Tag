package com.keboda.eomsback.produce.mapper;

import com.keboda.eomsback.entity.SearchVo;
import com.keboda.eomsback.produce.pojo.SfvFile;
import com.keboda.eomsback.produce.pojo.SfvFileKey;

import java.util.List;

public interface SfvFileMapper {

    int insertSelective(SfvFile record);

    int updateByPrimaryKeySelective(SfvFile record);

    List<SfvFile> searchSfvList(SearchVo searchVo);
}