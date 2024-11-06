package com.keboda.eomsback.system.mapper;

import com.github.pagehelper.Page;
import com.keboda.eomsback.entity.SearchVo;
import com.keboda.eomsback.system.pojo.SmyFile;

public interface SmyFileMapper {

    int insertSelective(SmyFile record);

    int updateByPrimaryKeySelective(SmyFile record);

    Page<SmyFile> searchSmyListPageHelper(SearchVo searchVo);
}