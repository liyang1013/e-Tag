package com.keboda.eomsback.system.service;

import com.github.pagehelper.Page;
import com.keboda.eomsback.entity.SearchVo;
import com.keboda.eomsback.system.pojo.SmyFile;

public interface ISmyService {

    Page<SmyFile> searchSmyListPageHelper(SearchVo searchVo);
}
