package com.keboda.eomsback.flux.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.keboda.eomsback.flux.mapper.RcsMapper;
import com.keboda.eomsback.flux.service.IRcsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@DS("fluxRcs")
public class RcsServiceImpl implements IRcsService {

    @Resource
    private RcsMapper rcsMapper;

    @Override
    public String getFinishedTask(String tableName, String taskid) {
        return rcsMapper.getFinishedTask(tableName, taskid);
    }
}
