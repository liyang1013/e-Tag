package com.keboda.eomsback.produce.service.impl;

import com.keboda.eomsback.entity.SearchVo;
import com.keboda.eomsback.produce.mapper.EciFileMapper;
import com.keboda.eomsback.produce.pojo.EciFile;
import com.keboda.eomsback.produce.service.IEciService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EciServiceImpl implements IEciService {
    @Resource
    private EciFileMapper eciFileMapper;

    @Override
    public List<EciFile> searchEciList(SearchVo searchVo) {
        return eciFileMapper.searchEciList(searchVo);
    }

    @Override
    public EciFile searchEciByKey(SearchVo searchVo) {
        return eciFileMapper.searchEciByKey(searchVo);
    }
}
