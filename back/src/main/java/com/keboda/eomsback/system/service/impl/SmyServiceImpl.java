package com.keboda.eomsback.system.service.impl;

import com.github.pagehelper.Page;
import com.keboda.eomsback.entity.SearchVo;
import com.keboda.eomsback.system.mapper.SmyFileMapper;
import com.keboda.eomsback.system.pojo.SmyFile;
import com.keboda.eomsback.system.service.ISmyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SmyServiceImpl implements ISmyService {

    @Resource
    private SmyFileMapper smyFileMapper;


    @Override
    public Page<SmyFile> searchSmyListPageHelper(SearchVo searchVo) {
        return smyFileMapper.searchSmyListPageHelper(searchVo);
    }
}
