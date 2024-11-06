package com.keboda.eomsback.produce.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * QCF_FILE
 *
 * @author
 */
@Data
public class QcfFile implements Serializable {
    private String qcf01;

    private String qcf00;

    private String qcf02;

    private String qcf021;

    private String qcf03;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date qcf04;

    private String qcf041;

    private Integer qcf05;

    private BigDecimal qcf06;

    private BigDecimal qcf061;

    private String qcf062;

    private BigDecimal qcf071;

    private String qcf072;

    private BigDecimal qcf081;

    private String qcf082;

    private String qcf09;

    private BigDecimal qcf091;

    private String qcf10;

    private Integer qcf101;

    private String qcf11;

    private String qcf12;

    private String qcf13;

    private String qcf14;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date qcf15;

    private String qcf16;

    private String qcf17;

    private String qcf18;

    private String qcf19;

    private String qcf20;

    private String qcf21;

    private BigDecimal qcf22;

    private Integer qcfprno;

    private String qcfacti;

    private String qcfuser;

    private String qcfgrup;

    private String qcfmodu;

    private Date qcfdate;

    private String qcf30;

    private BigDecimal qcf31;

    private BigDecimal qcf32;

    private String qcf33;

    private BigDecimal qcf34;

    private BigDecimal qcf35;

    private String qcf36;

    private BigDecimal qcf37;

    private BigDecimal qcf38;

    private String qcf39;

    private BigDecimal qcf40;

    private BigDecimal qcf41;

    private String qcfspc;

    private String qcfud01;

    private String qcfud02;

    private String qcfud03;

    private String qcfud04;

    private String qcfud05;

    private String qcfud06;

    private BigDecimal qcfud07;

    private BigDecimal qcfud08;

    private BigDecimal qcfud09;

    private Long qcfud10;

    private Long qcfud11;

    private Long qcfud12;

    private Date qcfud13;

    private Date qcfud14;

    private Date qcfud15;

    private String qcfplant;

    private String qcflegal;

    private String qcforiu;

    private String qcforig;

    private static final long serialVersionUID = 1L;
}
