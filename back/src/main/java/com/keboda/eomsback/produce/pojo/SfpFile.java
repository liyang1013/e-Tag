package com.keboda.eomsback.produce.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.keboda.eomsback.entity.CommonField;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * SFP_FILE
 *
 * @author
 */
@Data
public class SfpFile extends CommonField implements Serializable {
    private String sfp01;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date sfp02;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date sfp03;

    private String sfp04;

    private String sfp05;

    private String sfp06;

    private String sfp07;

    private String sfp08;

    private String sfp09;

    private String sfp10;

    private String sfpuser;

    private String sfpgrup;

    private String sfpmodu;

    private Date sfpdate;

    private String sfp11;

    private String sfpconf;

    private String sfpud01;

    private String sfpud02;

    private String sfpud03;

    private String sfpud04;

    private String sfpud05;

    private String sfpud06;

    private BigDecimal sfpud07;

    private BigDecimal sfpud08;

    private BigDecimal sfpud09;

    private Long sfpud10;

    private Long sfpud11;

    private Long sfpud12;

    private Date sfpud13;

    private Date sfpud14;

    private Date sfpud15;

    private String sfp12;

    private String sfp13;

    private String sfp14;

    private String sfpplant;

    private String sfplegal;

    private String sfporiu;

    private String sfporig;

    private String sfp15;

    private String sfp16;

    private String sfpmksg;

    /**
     * 异动日期
     */

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date tlf06;

    private String tlf907;

    private BigDecimal sfq03;

    private static final long serialVersionUID = 1L;
}
