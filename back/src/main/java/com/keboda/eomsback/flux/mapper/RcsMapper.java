package com.keboda.eomsback.flux.mapper;

import org.apache.ibatis.annotations.Param;

public interface RcsMapper {
    String getFinishedTask(@Param("table") String tableName, @Param("taskid") String taskid);
}
