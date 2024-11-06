package com.keboda.eomsback.produce.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.keboda.eomsback.entity.CommonField;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 工单表体
 * SFB_FILE
 *
 * @author
 */
@Data
public class SfbFile extends CommonField implements Serializable {
    private String sfb01;

    private Integer sfb02;

    private String sfb03;

    private String sfb04;

    private String sfb05;

    private String sfb06;

    private String sfb07;

    private Date sfb071;

    private BigDecimal sfb08;

    private BigDecimal sfb081;

    private BigDecimal sfb09;

    private BigDecimal sfb10;

    private BigDecimal sfb11;

    private BigDecimal sfb111;

    private BigDecimal sfb12;

    private BigDecimal sfb121;

    private BigDecimal sfb122;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date sfb13;

    private String sfb14;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date sfb15;

    private String sfb16;

    private Integer sfb17;

    private Date sfb18;

    private String sfb19;

    private Date sfb20;

    private String sfb21;

    private String sfb22;

    private Integer sfb221;

    private String sfb222;

    private String sfb23;

    private String sfb24;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date sfb25;

    private Date sfb251;

    private String sfb26;

    private String sfb27;

    private String sfb271;

    private String sfb28;

    private String sfb29;

    private String sfb30;

    private String sfb31;

    private String sfb32;

    private String sfb33;

    private BigDecimal sfb34;

    private String sfb35;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date sfb36;

    private Date sfb37;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date sfb38;

    private String sfb39;

    private Integer sfb40;

    private String sfb41;

    private Integer sfb42;


    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date sfb81;

    private String sfb82;

    private String sfb85;

    private String sfb86;

    private String sfb87;

    private String sfb88;

    private String sfb91;

    private Integer sfb92;

    private String sfb93;

    private String sfb94;

    private String sfb95;

    private String sfb96;

    private String sfb97;

    private String sfb98;

    private String sfb99;

    private String sfb100;

    private Integer sfb101;

    private String sfbacti;

    private String sfbuser;

    private String sfbgrup;

    private String sfbmodu;

    private Date sfbdate;

    private String sfb1001;

    private String sfb1002;

    private String sfb1003;

    private String sfb102;

    private String sfb50;

    private String sfb51;

    private Integer sfb103;

    private String sfbud01;

    private String sfbud02;

    private String sfbud03;

    private String sfbud04;

    private String sfbud05;

    private String sfbud06;

    private BigDecimal sfbud07;

    private BigDecimal sfbud08;

    private BigDecimal sfbud09;

    private Long sfbud10;

    private Long sfbud11;

    private Long sfbud12;

    private Date sfbud13;

    private Date sfbud14;

    private Date sfbud15;

    private String sfb43;

    private String sfb44;

    private String sfbmksg;

    private String sfbplant;

    private String sfblegal;

    private String sfboriu;

    private String sfborig;

    private String sfb104;

    private String sfb919;

    private String sfb89;

    private static final long serialVersionUID = 1L;
}
