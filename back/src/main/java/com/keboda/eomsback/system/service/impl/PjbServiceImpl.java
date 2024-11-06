package com.keboda.eomsback.system.service.impl;

import com.keboda.eomsback.entity.SearchVo;
import com.keboda.eomsback.system.mapper.PjbFileMapper;
import com.keboda.eomsback.system.pojo.PjbFile;
import com.keboda.eomsback.system.service.IPjbService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PjbServiceImpl implements IPjbService {

    @Resource
    private PjbFileMapper pjbFileMapper;

    @Override
    public List<PjbFile> searchPjbList(SearchVo searchVo) {
        return pjbFileMapper.searchPjbList(searchVo);
    }

    @Override
    public PjbFile searchPjbByKey(SearchVo searchVo) {
        return pjbFileMapper.searchPjbByKey(searchVo);
    }
}
