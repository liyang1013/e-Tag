package com.keboda.eomsback.sale.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.keboda.eomsback.entity.CommonField;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * OHA_FILE
 */
@Data
public class OhaFile extends CommonField implements Serializable {
    private String oha01;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date oha02;

    private String oha03;

    private String oha032;

    private String oha04;

    private String oha05;

    private String oha08;

    private String oha09;

    private String oha10;

    private String oha14;

    private String oha15;

    private String oha16;

    private String oha17;

    private String oha21;

    private BigDecimal oha211;

    private String oha212;

    private String oha213;

    private String oha23;

    private BigDecimal oha24;

    private String oha25;

    private String oha26;

    private String oha31;

    private String oha41;

    private String oha42;

    private String oha43;

    private String oha44;

    private String oha45;

    private String oha46;

    private String oha47;

    private String oha48;

    private BigDecimal oha50;

    private BigDecimal oha53;

    private BigDecimal oha54;

    private String oha99;

    private String ohaconf;

    private String ohapost;

    private Integer ohaprsw;

    private String ohauser;

    private String ohagrup;

    private String ohamodu;

    private Date ohadate;

    private String oha55;

    private String ohamksg;

    private String oha1001;

    private String oha1002;

    private String oha1003;

    private String oha1004;

    private String oha1005;

    private BigDecimal oha1006;

    private BigDecimal oha1007;

    private BigDecimal oha1008;

    private String oha1009;

    private String oha1010;

    private String oha1011;

    private String oha1012;

    private String oha1013;

    private String oha1014;

    private String oha1015;

    private String oha1016;

    private String oha1017;

    private String oha1018;

    private BigDecimal oha1019;

    private BigDecimal oha1020;

    private String oha100;

    private String oha101;

    private Date oha102;

    private String oha56;

    private String ohaud01;

    private String ohaud02;

    private String ohaud03;

    private String ohaud04;

    private String ohaud05;

    private String ohaud06;

    private BigDecimal ohaud07;

    private BigDecimal ohaud08;

    private BigDecimal ohaud09;

    private Long ohaud10;

    private Long ohaud11;

    private Long ohaud12;

    private Date ohaud13;

    private Date ohaud14;

    private Date ohaud15;

    private String oha85;

    private String oha86;

    private String oha87;

    private String oha88;

    private String oha89;

    private String oha90;

    private String oha91;

    private String oha92;

    private String oha93;

    private String oha94;

    private BigDecimal oha95;

    private String oha96;

    private Integer oha97;

    private Date ohacond;

    private String ohaconu;

    private String ohaplant;

    private String ohalegal;

    private String ohaoriu;

    private String ohaorig;

    private String oha98;

    private String oha57;

    private String ohacont;

    private String ohaslk02;

    private static final long serialVersionUID = 1L;
}