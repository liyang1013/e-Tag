package com.keboda.eomsback.purchase.service.impl;

import com.github.pagehelper.Page;
import com.keboda.eomsback.entity.SearchVo;
import com.keboda.eomsback.purchase.mapper.PmaFileMapper;
import com.keboda.eomsback.purchase.pojo.PmaFile;
import com.keboda.eomsback.purchase.service.IPmaService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PmaServiceImpl implements IPmaService {

    @Resource
    private PmaFileMapper pmaFileMapper;

    @Override
    public Page<PmaFile> searchListPageHelper(SearchVo searchVo) {
        return pmaFileMapper.searchListPageHelper(searchVo);
    }
}
