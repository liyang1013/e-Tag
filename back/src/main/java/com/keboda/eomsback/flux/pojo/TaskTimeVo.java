package com.keboda.eomsback.flux.pojo;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class TaskTimeVo {

    private List<Integer> carid;

    private String taskid;

    private List<String> tasktype;

    private List<String> wmstasktype;

    private Date startdate;

    private Date enddate;

    private Integer currentPage = 1;

    private Integer size = 20;

    private Integer total;
}
