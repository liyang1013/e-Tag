package com.keboda.eomsback.system.service.impl;

import com.keboda.eomsback.entity.SearchVo;
import com.keboda.eomsback.system.mapper.PjaFileMapper;
import com.keboda.eomsback.system.pojo.PjaFile;
import com.keboda.eomsback.system.service.IPjaService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PjaServiceImpl implements IPjaService {

    @Resource
    private PjaFileMapper pjaFileMapper;

    @Override
    public List<PjaFile> searchPjaList(SearchVo searchVo) {
        return pjaFileMapper.searchPjaList(searchVo);
    }

    @Override
    public PjaFile searchPjaByKey(SearchVo searchVo) {
        return pjaFileMapper.searchPjaByKey(searchVo);
    }
}
