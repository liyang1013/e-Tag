package com.keboda.eomsback.purchase.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.keboda.eomsback.entity.CommonField;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * RVU_FILE
 *
 * @author
 */
@Data
public class RvuFile extends CommonField implements Serializable {
    private String rvu01;

    private String rvu00;

    private String rvu02;


    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date rvu03;

    private String rvu04;

    private String rvu05;

    private String rvu06;

    private String rvu07;

    private String rvu08;

    private Date rvu09;

    private String rvu10;

    private Date rvu11;

    private BigDecimal rvu12;

    private BigDecimal rvu13;

    private BigDecimal rvu14;

    private String rvu15;

    private String rvu20;

    private String rvu99;

    private String rvuconf;

    private String rvuacti;

    private String rvuuser;

    private String rvugrup;

    private String rvumodu;

    private Date rvudate;

    private String rvu100;

    private String rvu101;

    private Date rvu102;

    private String rvuud01;

    private String rvuud02;

    private String rvuud03;

    private String rvuud04;

    private String rvuud05;

    private String rvuud06;

    private BigDecimal rvuud07;

    private BigDecimal rvuud08;

    private BigDecimal rvuud09;

    private Long rvuud10;

    private Long rvuud11;

    private Long rvuud12;

    private Date rvuud13;

    private Date rvuud14;

    private Date rvuud15;

    private String rvu16;

    private String rvu111;

    private String rvu112;

    private String rvu113;

    private String rvu115;

    private String rvu116;

    private String rvu117;

    private BigDecimal rvu114;

    private String rvu21;

    private String rvu22;

    private String rvu23;

    private String rvu24;

    private String rvu900;

    private Date rvucond;

    private String rvucont;

    private String rvuconu;

    private Date rvucrat;

    private Integer rvudays;

    private String rvumksg;

    private Integer rvuprit;

    private String rvusign;

    private Integer rvusmax;

    private Integer rvusseq;

    private String rvupos;

    private String rvuplant;

    private String rvulegal;

    private String rvuoriu;

    private String rvuorig;

    private String rvu25;

    private String rvu17;

    private String rvu26;

    private String rvu27;

    private static final long serialVersionUID = 1L;
}