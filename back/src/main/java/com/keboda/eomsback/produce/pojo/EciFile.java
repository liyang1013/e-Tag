package com.keboda.eomsback.produce.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * ECI_FILE
 */
@Data
public class EciFile implements Serializable {
    private String eci01;

    private String eci02;

    private String eci03;

    private BigDecimal eci04;

    private Long eci05;

    private String eci06;

    private Integer eci07;

    private Integer eci08;

    private String eciacti;

    private String eciuser;

    private String ecigrup;

    private String ecimodu;

    private Date ecidate;

    private Long eci09;

    private String ecioriu;

    private String eciorig;

    private BigDecimal eci10;

    private static final long serialVersionUID = 1L;
}