package com.keboda.eomsback.system.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.keboda.eomsback.system.mapper.AzpFileMapper;
import com.keboda.eomsback.system.pojo.AzpFile;
import com.keboda.eomsback.system.service.IAzpService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AzpServiceImpl implements IAzpService {

    @Resource
    private AzpFileMapper azpFileMapper;


    @Override
    public List<AzpFile> searchAzpList(String azp01) {
        return azpFileMapper.searchAzpList(azp01);
    }

    @Override
    public AzpFile selectByPrimaryKey(String azp01) {
        return azpFileMapper.selectByPrimaryKey(azp01);
    }
}
