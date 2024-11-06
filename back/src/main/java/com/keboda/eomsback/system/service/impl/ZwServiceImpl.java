package com.keboda.eomsback.system.service.impl;

import com.keboda.eomsback.system.mapper.ZwFileMapper;
import com.keboda.eomsback.system.pojo.ZwFile;
import com.keboda.eomsback.system.service.IZwService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ZwServiceImpl implements IZwService {

    @Resource
    private ZwFileMapper zwFileMapper;


    @Override
    public List<ZwFile> searchZwList(String query) {
        return zwFileMapper.searchZwList(query);
    }

    @Override
    public ZwFile selectByPrimaryKey(String zw01) {
        return zwFileMapper.selectByPrimaryKey(zw01);
    }
}
