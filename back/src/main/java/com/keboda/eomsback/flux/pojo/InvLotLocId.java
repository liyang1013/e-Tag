package com.keboda.eomsback.flux.pojo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class InvLotLocId implements Serializable {

    private String organizationid;

    private String warehouseid;

    private String locationid;

    private String lotnum;

    private String traceid;

    private String customerid;

    private String sku;

    private BigDecimal qty;

    private BigDecimal qtyallocated;

    private BigDecimal qtyrpin;

    private BigDecimal qtyrpout;

    private BigDecimal qtymvin;

    private BigDecimal qtymvout;

    private BigDecimal qtyonhold;

    private Integer onholdlocker;

    private BigDecimal grossweight;

    private BigDecimal netweight;

    private BigDecimal cubic;

    private BigDecimal price;

    private BigDecimal qtypa;

    private String qcstatus;

    private Date lastmaintenancedate;

    private String notetext;

    private String udf01;

    private String udf02;

    private String udf03;

    private String udf04;

    private String udf05;

    private String udf06;

    private Integer currentversion;

    private String oprseqflag;

    private String addwho;

    private Date addtime;

    private String editwho;

    private Date edittime;

    private Date inloctime;

    private String muid;

    private String skudescr1;

    private String packdescr;

    private String skudescr2;

    private String packid;

    private String freightclass;

    private String packuom;

    private BigDecimal asqtyavailed;

    private String lotatt04;

    private String lotatt05;

    private String lotatt06;

    private String lotatt07;

    private String lotatt08;

    private BigDecimal iqty;

    private static final long serialVersionUID = 1L;

}
