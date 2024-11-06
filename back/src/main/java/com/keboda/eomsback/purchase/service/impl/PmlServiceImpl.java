package com.keboda.eomsback.purchase.service.impl;

import com.keboda.eomsback.entity.SearchVo;
import com.keboda.eomsback.purchase.mapper.PmlFileMapper;
import com.keboda.eomsback.purchase.pojo.PmlFile;
import com.keboda.eomsback.purchase.service.IPmlService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PmlServiceImpl implements IPmlService{

    @Resource
    private PmlFileMapper pmlFileMapper;

    @Override
    public List<PmlFile> searchListByOrderCode(SearchVo searchVo) {
        return pmlFileMapper.searchListByOrderCode(searchVo);
    }
}
