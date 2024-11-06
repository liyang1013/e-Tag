package com.keboda.eomsback.flux.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class TaskStatus {

    private String taskid;

    private String tasktype;

    private String status;

    private Date completionTime;

    private  Date addTime;
}
