package com.keboda.eomsback.sale.service.impl;

import com.github.pagehelper.Page;
import com.keboda.eomsback.entity.SearchVo;
import com.keboda.eomsback.sale.mapper.OccFileMapper;
import com.keboda.eomsback.sale.pojo.OccFile;
import com.keboda.eomsback.sale.service.IOccService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class OccServiceImpl implements IOccService {

    @Resource
    private OccFileMapper occFileMapper;

    @Override
    public Page<OccFile> searchOccListPageHelper(SearchVo searchVo) {
        return occFileMapper.searchOccListPageHelper(searchVo);
    }
}
