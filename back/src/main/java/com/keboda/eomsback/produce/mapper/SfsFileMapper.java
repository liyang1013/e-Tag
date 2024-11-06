package com.keboda.eomsback.produce.mapper;

import com.keboda.eomsback.entity.SearchVo;
import com.keboda.eomsback.produce.pojo.SfpFile;
import com.keboda.eomsback.produce.pojo.SfsFile;
import com.keboda.eomsback.produce.pojo.SfsFileKey;

import java.util.List;

public interface SfsFileMapper {

    int insertSelective(SfsFile record);

    int updateByPrimaryKeySelective(SfsFile record);

    List<SfsFile> searchSlaveList(SearchVo searchVo);
}