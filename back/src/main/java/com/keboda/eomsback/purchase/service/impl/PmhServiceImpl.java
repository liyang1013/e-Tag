package com.keboda.eomsback.purchase.service.impl;

import com.github.pagehelper.Page;
import com.keboda.eomsback.entity.SearchVo;
import com.keboda.eomsback.purchase.mapper.PmhFileMapper;
import com.keboda.eomsback.purchase.pojo.PmhFile;
import com.keboda.eomsback.purchase.service.IPmhService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PmhServiceImpl implements IPmhService {

    @Resource
    private PmhFileMapper pmhFileMapper;

    @Override
    public Page<PmhFile> searchListPageHelper(SearchVo searchVo) {
        return pmhFileMapper.searchListPageHelper(searchVo);
    }
}
