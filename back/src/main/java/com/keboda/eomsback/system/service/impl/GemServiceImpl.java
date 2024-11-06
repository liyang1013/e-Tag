package com.keboda.eomsback.system.service.impl;

import com.keboda.eomsback.entity.SearchVo;
import com.keboda.eomsback.system.mapper.GemFileMapper;
import com.keboda.eomsback.system.pojo.GemFile;
import com.keboda.eomsback.system.service.IGemService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GemServiceImpl implements IGemService {

    @Resource
    private GemFileMapper gemFileMapper;

    @Override
    public List<GemFile> searchGemList(SearchVo searchVo) {
        return gemFileMapper.searchGemList(searchVo);
    }

    @Override
    public GemFile searchGemByKey(SearchVo searchVo) {
        return gemFileMapper.searchGemByKey(searchVo);
    }
}
