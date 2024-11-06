package com.keboda.eomsback.produce.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * SHB_FILE
 *
 * @author
 */
@Data
public class ShbFile implements Serializable {
    private String shb01;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date shb02;

    private String shb021;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date shb03;

    private String shb031;

    private String shb04;

    private String shb05;

    private Integer shb06;

    private String shb07;

    private String shb08;

    private String shb081;

    private String shb082;

    private String shb09;

    private String shb10;

    private BigDecimal shb111;

    private BigDecimal shb112;

    private BigDecimal shb113;

    private BigDecimal shb114;

    private BigDecimal shb115;

    private Integer shb12;

    private String shb13;

    private String shb14;

    private Integer shb15;

    private String shb16;

    private BigDecimal shb17;

    private String shb18;

    private String shb19;

    private String shb20;

    private Date shbinp;

    private String shbacti;

    private String shbuser;

    private String shbgrup;

    private String shbmodu;

    private Date shbdate;

    private String shbud01;

    private String shbud02;

    private String shbud03;

    private String shbud04;

    private String shbud05;

    private String shbud06;

    private BigDecimal shbud07;

    private BigDecimal shbud08;

    private BigDecimal shbud09;

    private Long shbud10;

    private Long shbud11;

    private Long shbud12;

    private Date shbud13;

    private Date shbud14;

    private Date shbud15;

    private String shb21;

    private String shb22;

    private String shbplant;

    private String shblegal;

    private String shboriu;

    private String shborig;

    private String shb012;

    private String shb121;

    private String shb23;

    private Integer shb24;

    private String shb25;

    private String shb26;

    private String shb27;

    private String shb28;

    private String shb29;

    private String shb30;

    private String shb31;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date shb32;

    private String shbconf;

    private String shb34;

    private BigDecimal shb032;

    private BigDecimal shb033;

    private static final long serialVersionUID = 1L;
}
