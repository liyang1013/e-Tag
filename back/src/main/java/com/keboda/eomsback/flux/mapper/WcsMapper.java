package com.keboda.eomsback.flux.mapper;

import com.github.pagehelper.Page;
import com.keboda.eomsback.flux.pojo.TaskStatus;
import com.keboda.eomsback.flux.pojo.TaskTimeVo;
import com.keboda.eomsback.flux.pojo.RobotsTaskTime;
import com.keboda.eomsback.plc.pojo.Car;
import com.keboda.eomsback.plc.pojo.Hoist;

import java.util.List;

public interface WcsMapper {
    Page<RobotsTaskTime> taskTimePageHelper(TaskTimeVo vo);

    void writerCarinfo(Car car);

    void writerHoistinfo(Hoist hoist);

    List<TaskStatus> getUnFinishedTask();

    void clearTaskStatusTable();

    void insertTaskStatusGap(TaskStatus t);
}
