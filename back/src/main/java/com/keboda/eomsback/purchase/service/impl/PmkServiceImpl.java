package com.keboda.eomsback.purchase.service.impl;

import com.github.pagehelper.Page;
import com.keboda.eomsback.entity.SearchVo;
import com.keboda.eomsback.purchase.mapper.PmkFileMapper;
import com.keboda.eomsback.purchase.pojo.PmkFile;
import com.keboda.eomsback.purchase.service.IPmkService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PmkServiceImpl implements IPmkService {

    @Resource
    private PmkFileMapper pmkFileMapper;

    @Override
    public Page<PmkFile> searchListPageHelper(SearchVo searchVo) {
        return pmkFileMapper.searchListPageHelper(searchVo);
    }
}
