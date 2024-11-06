package com.keboda.eomsback.system.service.impl;

import com.keboda.eomsback.entity.SearchVo;
import com.keboda.eomsback.system.mapper.GfeFileMapper;
import com.keboda.eomsback.system.pojo.GfeFile;
import com.keboda.eomsback.system.service.IGfeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GfeServiceImpl  implements IGfeService {

    @Resource
    private GfeFileMapper gfeFileMapper;

    @Override
    public List<GfeFile> searchGfeList(SearchVo searchVo) {
        return gfeFileMapper.searchGfeList(searchVo);
    }

    @Override
    public GfeFile searchGfeByKey(SearchVo searchVo) {
        return gfeFileMapper.searchGfeByKey(searchVo);
    }
}
