package com.keboda.eomsback.purchase.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.keboda.eomsback.entity.CommonField;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * PMK_FILE
 *
 * @author
 */
@Data
public class PmkFile extends CommonField implements Serializable {
    private String pmk01;

    private String pmk02;

    private Integer pmk03;


    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date pmk04;

    private String pmk05;

    private String pmk06;

    private String pmk07;

    private String pmk08;

    private String pmk09;

    private String pmk10;

    private String pmk11;

    private String pmk12;

    private String pmk13;

    private String pmk14;

    private String pmk15;

    private String pmk16;

    private String pmk17;

    private String pmk18;

    private String pmk20;

    private String pmk21;

    private String pmk22;

    private String pmk25;

    private String pmk26;

    private Date pmk27;

    private String pmk28;

    private String pmk29;

    private String pmk30;

    private Integer pmk31;

    private Integer pmk32;

    private BigDecimal pmk40;

    private BigDecimal pmk401;

    private String pmk41;

    private BigDecimal pmk42;

    private BigDecimal pmk43;

    private String pmk45;

    private String pmkprsw;

    private Integer pmkprno;

    private Date pmkprdt;

    private String pmkmksg;

    private String pmksign;

    private Integer pmkdays;

    private Integer pmkprit;

    private Integer pmksseq;

    private Integer pmksmax;

    private String pmkacti;

    private String pmkuser;

    private String pmkgrup;

    private String pmkmodu;

    private Date pmkdate;

    private String pmkud01;

    private String pmkud02;

    private String pmkud03;

    private String pmkud04;

    private String pmkud05;

    private String pmkud06;

    private BigDecimal pmkud07;

    private BigDecimal pmkud08;

    private BigDecimal pmkud09;

    private Long pmkud10;

    private Long pmkud11;

    private Long pmkud12;

    private Date pmkud13;

    private Date pmkud14;

    private Date pmkud15;

    private String pmk46;

    private String pmk47;

    private String pmk48;

    private Date pmkcond;

    private String pmkconu;

    private Date pmkcrat;

    private String pmkcont;

    private String pmkplant;

    private String pmklegal;

    private String pmkoriu;

    private String pmkorig;

    private String pmk49;

    private String pmk50;

    private String pmk51;

    private static final long serialVersionUID = 1L;
}