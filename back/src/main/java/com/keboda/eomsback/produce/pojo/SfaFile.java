package com.keboda.eomsback.produce.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * 工单表头
 * SFA_FILE
 * @author
 */
@Data
public class SfaFile extends SfaFileKey implements Serializable {
    private Integer sfa02;

    private BigDecimal sfa04;

    private BigDecimal sfa05;

    private BigDecimal sfa06;

    private BigDecimal sfa061;

    private BigDecimal sfa062;

    private BigDecimal sfa063;

    private BigDecimal sfa064;

    private BigDecimal sfa065;

    private BigDecimal sfa066;

    private BigDecimal sfa07;

    private Integer sfa09;

    private String sfa10;

    private String sfa11;

    private BigDecimal sfa13;

    private String sfa14;

    private BigDecimal sfa15;

    private BigDecimal sfa16;

    private BigDecimal sfa161;

    private BigDecimal sfa25;

    private String sfa26;

    private BigDecimal sfa28;

    private String sfa29;

    private String sfa30;

    private String sfa31;

    private String sfa91;

    private String sfa92;

    private String sfa93;

    private String sfa94;

    private String sfa95;

    private String sfa96;

    private String sfa97;

    private String sfa98;

    private String sfa99;

    private BigDecimal sfa100;

    private String sfaacti;

    private String sfa32;

    private String sfaud01;

    private String sfaud02;

    private String sfaud03;

    private String sfaud04;

    private String sfaud05;

    private String sfaud06;

    private BigDecimal sfaud07;

    private BigDecimal sfaud08;

    private BigDecimal sfaud09;

    private Long sfaud10;

    private Long sfaud11;

    private Long sfaud12;

    private Date sfaud13;

    private Date sfaud14;

    private Date sfaud15;

    private String sfa36;

    private String sfaplant;

    private String sfalegal;

    private static final long serialVersionUID = 1L;
}
