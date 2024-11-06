package com.keboda.eomsback.purchase.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * PMH_FILE
 *
 * @author
 */
@Data
public class PmhFile extends PmhFileKey implements Serializable {
    private String pmh03;

    private String pmh04;

    private String pmh05;


    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date pmh06;

    private String pmh07;

    private String pmh08;

    private String pmh09;

    private Date pmh10;

    private BigDecimal pmh11;

    private BigDecimal pmh12;

    private BigDecimal pmh14;

    private String pmh15;

    private String pmh16;

    private String pmhacti;

    private String pmhuser;

    private String pmhgrup;

    private String pmhmodu;

    private Date pmhdate;

    private String pmh17;

    private BigDecimal pmh18;

    private BigDecimal pmh19;

    private String pmh20;

    private String pmh24;

    private String pmhorig;

    private String pmhoriu;

    private String pmh25;

    private static final long serialVersionUID = 1L;
}