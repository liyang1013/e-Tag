package com.keboda.eomsback.purchase.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.keboda.eomsback.entity.CommonField;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * PMM_FILE
 *
 * @author
 */
@Data
public class PmmFile extends CommonField implements Serializable {
    private String pmm01;

    private String pmm02;

    private Integer pmm03;


    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date pmm04;

    private String pmm05;

    private String pmm06;

    private String pmm07;

    private String pmm08;

    private String pmm09;

    private String pmm10;

    private String pmm11;

    private String pmm12;

    private String pmm13;

    private String pmm14;

    private String pmm15;

    private String pmm16;

    private String pmm17;

    private String pmm18;

    private String pmm20;

    private String pmm21;

    private String pmm22;

    private String pmm25;

    private String pmm26;

    private Date pmm27;

    private String pmm28;

    private String pmm29;

    private String pmm30;

    private Integer pmm31;

    private Integer pmm32;

    private BigDecimal pmm40;

    private BigDecimal pmm401;

    private String pmm41;

    private BigDecimal pmm42;

    private BigDecimal pmm43;

    private String pmm44;

    private String pmm45;

    private Integer pmm46;

    private BigDecimal pmm47;

    private BigDecimal pmm48;

    private String pmm49;

    private String pmm50;

    private String pmm99;

    private String pmm901;

    private String pmm902;

    private String pmm903;

    private String pmm904;

    private String pmm905;

    private String pmm906;

    private String pmm907;

    private Date pmm908;

    private String pmm909;

    private String pmm911;

    private String pmm912;

    private String pmm913;

    private String pmm914;

    private String pmm915;

    private String pmm916;

    private String pmmprsw;

    private Integer pmmprno;

    private Date pmmprdt;

    private String pmmmksg;

    private String pmmsign;

    private Integer pmmdays;

    private Integer pmmprit;

    private Integer pmmsseq;

    private Integer pmmsmax;

    private String pmmacti;

    private String pmmuser;

    private String pmmgrup;

    private String pmmmodu;

    private Date pmmdate;

    private BigDecimal pmm40t;

    private String pmmud01;

    private String pmmud02;

    private String pmmud03;

    private String pmmud04;

    private String pmmud05;

    private String pmmud06;

    private BigDecimal pmmud07;

    private BigDecimal pmmud08;

    private BigDecimal pmmud09;

    private Long pmmud10;

    private Long pmmud11;

    private Long pmmud12;

    private Date pmmud13;

    private Date pmmud14;

    private Date pmmud15;

    private String pmm51;

    private String pmm52;

    private String pmm53;

    private Date pmmcond;

    private String pmmcont;

    private String pmmconu;

    private Date pmmcrat;

    private String pmmpos;

    private String pmmplant;

    private String pmmlegal;

    private String pmmoriu;

    private String pmmorig;

    private static final long serialVersionUID = 1L;
}