package com.keboda.eomsback.flux.pojo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class InvLot implements Serializable {

    private String organizationid;

    private String warehouseid;

    private String lotnum;

    private String customerid;

    private String sku;

    private BigDecimal qty;

    private BigDecimal qtyallocated;

    private BigDecimal qtypreallocated;

    private BigDecimal qtyonhold;

    private BigDecimal grossweight;

    private BigDecimal netweight;

    private BigDecimal cubic;

    private BigDecimal price;

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

    private static final long serialVersionUID = 1L;
}
