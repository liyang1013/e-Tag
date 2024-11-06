package com.keboda.eomsback.flux.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.github.pagehelper.Page;
import com.keboda.eomsback.flux.pojo.TaskStatus;
import com.keboda.eomsback.flux.pojo.TaskTimeVo;
import com.keboda.eomsback.flux.mapper.WcsMapper;
import com.keboda.eomsback.flux.pojo.RobotsTaskTime;
import com.keboda.eomsback.flux.service.IWcsService;
import com.keboda.eomsback.plc.pojo.Car;
import com.keboda.eomsback.plc.pojo.Hoist;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@DS("fluxWcs")
public class WcsServiceImpl implements IWcsService {

    @Resource
    private WcsMapper wcsMapper;

    @Override
    public Page<RobotsTaskTime> taskTimePageHelper(TaskTimeVo vo) {
        return wcsMapper.taskTimePageHelper(vo);
    }

    @Override
    @Transactional
    public void writerCarinfo(Car car) {
        wcsMapper.writerCarinfo(car);
    }

    @Override
    @Transactional
    public void writerHoistinfo(Hoist hoist) {
        wcsMapper.writerHoistinfo(hoist);
    }

    @Override
    public List<TaskStatus> getUnFinishedTask() {
        return wcsMapper.getUnFinishedTask();
    }

    @Override
    public void clearTaskStatusTable() {
        wcsMapper.clearTaskStatusTable();
    }

    @Override
    public void insertTaskStatusGap(TaskStatus t) {
        wcsMapper.insertTaskStatusGap(t);
    }
}
