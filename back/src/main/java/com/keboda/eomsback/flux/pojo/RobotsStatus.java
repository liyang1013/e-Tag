package com.keboda.eomsback.flux.pojo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class RobotsStatus implements Serializable {

    private Integer id;

    private String ip;

    private String agvtype;

    private BigDecimal xPosition;

    private BigDecimal yPosition;

    private BigDecimal xTarget;

    private BigDecimal yTarget;

    private Boolean enable;

    private Integer floorid;

    private Integer mapid;

    private String taskState;

    private String agvState;

    private Boolean loaded;

    private BigDecimal battery;

    private Boolean online;

    private Date updatetime;

    private static final long serialVersionUID = 1L;
}
