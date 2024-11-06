package com.keboda.eomsback.flux.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class RobotsTaskTime {

    private String carid;


    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date ddate;

    private String taskid;

    private String tasktype;

    private String wmstasktype;

    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date startdate;

    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date enddate;

    private String tasktime;
}
