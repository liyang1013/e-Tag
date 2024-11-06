package com.keboda.eomsback.stock.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * OBK_FILE
 * @author 
 */
@Data
public class ObkFile extends ObkFileKey implements Serializable {
    private String obk03;

    private Date obk04;

    private String obk06;

    private String obk07;

    private BigDecimal obk08;

    private BigDecimal obk09;

    private BigDecimal obk10;

    private String obk11;

    private String obk12;

    private String obk13;

    private String obk14;

    private String obkacti;

    private Date obkdate;

    private String obkgrup;

    private String obkuser;

    private String obkmodu;

    private String obkorig;

    private String obkoriu;

    private String tcObk15;

    private String centre;

    private static final long serialVersionUID = 1L;
}