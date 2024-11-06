package com.keboda.eomsback.produce.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.keboda.eomsback.entity.CommonField;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * SFU_FILE
 *
 * @author
 */
@Data
public class SfuFile extends CommonField implements Serializable {
    private String sfu01;

    private String sfu00;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date sfu02;

    private String sfu03;

    private String sfu04;

    private String sfu05;

    private String sfu06;

    private String sfu07;

    private String sfu08;

    private String sfu09;

    private String sfu10;

    private String sfu11;

    private String sfu12;

    private String sfu13;

    private String sfupost;

    private String sfuuser;

    private String sfugrup;

    private String sfumodu;

    private Date sfudate;

    private String sfuconf;

    private String sfuud01;

    private String sfuud02;

    private String sfuud03;

    private String sfuud04;

    private String sfuud05;

    private String sfuud06;

    private BigDecimal sfuud07;

    private BigDecimal sfuud08;

    private BigDecimal sfuud09;

    private Long sfuud10;

    private Long sfuud11;

    private Long sfuud12;

    private Date sfuud13;

    private Date sfuud14;

    private Date sfuud15;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date sfu14;

    private String sfuplant;

    private String sfulegal;

    private String sfuoriu;

    private String sfuorig;

    private String sfu15;

    private String sfu16;

    private String sfumksg;

    /**
     * 异动扣账日期
     */

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date tlf06;

    private String tlf907;

    private BigDecimal sfv09;

    private static final long serialVersionUID = 1L;
}
