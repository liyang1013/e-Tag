package com.keboda.eomsback.system.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.github.pagehelper.Page;
import com.keboda.eomsback.entity.SearchVo;
import com.keboda.eomsback.system.mapper.GazFileMapper;
import com.keboda.eomsback.system.pojo.GazFile;
import com.keboda.eomsback.system.service.IGazService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class GazServiceImpl implements IGazService {

    @Resource
    private GazFileMapper gazFileMapper;

    @Override
    public GazFile selectByPrimaryKey(String gaz01) {
        return gazFileMapper.selectByPrimaryKey(gaz01);
    }

    @Override
    public Page<GazFile> searchGazListPageHelper(SearchVo searchVo) {
        return gazFileMapper.searchGazListPageHelper(searchVo);
    }
}
