package com.keboda.eomsback.purchase.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.keboda.eomsback.entity.CommonField;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * RVA_FILE
 *
 * @author
 */
@Data
public class RvaFile extends CommonField implements Serializable {
    private String rva01;

    private String rva02;

    private String rva03;

    private String rva04;

    private String rva05;


    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date rva06;

    private String rva07;

    private String rva08;

    private String rva09;

    private String rva10;

    private String rvaprsw;

    private String rva20;

    private Date rva21;

    private String rva22;

    private Date rva23;

    private String rva24;

    private BigDecimal rva25;

    private String rva26;

    private BigDecimal rva27;

    private Date rva28;

    private String rva99;

    private String rvaconf;

    private Integer rvaprno;

    private String rvaacti;

    private String rvauser;

    private String rvagrup;

    private String rvamodu;

    private Date rvadate;

    private String rvaspc;

    private String rva100;

    private String rvaud01;

    private String rvaud02;

    private String rvaud03;

    private String rvaud04;

    private String rvaud05;

    private String rvaud06;

    private BigDecimal rvaud07;

    private BigDecimal rvaud08;

    private BigDecimal rvaud09;

    private Long rvaud10;

    private Long rvaud11;

    private Long rvaud12;


    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date rvaud13;


    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date rvaud14;

    private Date rvaud15;

    private String rva00;

    private String rva111;

    private String rva112;

    private String rva113;

    private BigDecimal rva114;

    private String rva115;

    private BigDecimal rva116;

    private String rva117;

    private String rva29;

    private String rva30;

    private String rva31;

    private Date rvacond;

    private String rvaconu;

    private Date rvacrat;

    private String rvaplant;

    private String rvalegal;

    private String rvaoriu;

    private String rvaorig;

    private String rva32;

    private String rva33;

    private String rvamksg;

    private String rvacont;

    private String rva34;

    private static final long serialVersionUID = 1L;
}