package com.keboda.eomsback.finance.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * OMB_FILE
 */
@Data
public class OmbFile extends OmbFileKey implements Serializable {
    private String omb00;

    private String omb04;

    private String omb05;

    private String omb06;

    private BigDecimal omb12;

    private BigDecimal omb13;

    private BigDecimal omb14;

    private BigDecimal omb14t;

    private BigDecimal omb15;

    private BigDecimal omb16;

    private BigDecimal omb16t;

    private BigDecimal omb17;

    private BigDecimal omb18;

    private BigDecimal omb18t;

    private String omb31;

    private Integer omb32;

    private String omb33;

    private BigDecimal omb34;

    private BigDecimal omb35;

    private BigDecimal omb36;

    private BigDecimal omb37;

    private String omb930;

    private String omb331;

    private String omb40;

    private String omb38;

    private String omb39;

    private String omb41;

    private String omb42;

    private String omb43;

    private String ombud01;

    private String ombud02;

    private String ombud03;

    private String ombud04;

    private String ombud05;

    private String ombud06;

    private BigDecimal ombud07;

    private BigDecimal ombud08;

    private BigDecimal ombud09;

    private Long ombud10;

    private Long ombud11;

    private Long ombud12;

    private Date ombud13;

    private Date ombud14;

    private Date ombud15;

    private String omblegal;

    private String omb44;

    private String omb45;

    private String omb46;

    private String omb47;

    private BigDecimal omb48;

    private static final long serialVersionUID = 1L;
}