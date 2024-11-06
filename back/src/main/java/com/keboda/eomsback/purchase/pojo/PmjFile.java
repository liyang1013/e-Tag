package com.keboda.eomsback.purchase.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * PMJ_FILE
 */
@Data
public class PmjFile extends PmjFileKey implements Serializable {
    private String pmj03;

    private String pmj031;

    private String pmj032;

    private String pmj04;

    private String pmj05;

    private BigDecimal pmj06;

    private BigDecimal pmj07;

    private Date pmj08;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date pmj09;

    private BigDecimal pmj06t;

    private BigDecimal pmj07t;

    private String pmj11;

    private String pmjplant;

    private String pmjlegal;

    private String pmj14;

    private String pmjicd14;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date pmj091;

    private String taPmjud01;

    private String taPmjud02;

    private String taPmjud03;

    private String taPmjud04;

    private Date taPmjud05;

    private String taPmj01;

    private String taPmj02;

    private static final long serialVersionUID = 1L;
}