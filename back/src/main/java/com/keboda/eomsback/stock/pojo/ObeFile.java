package com.keboda.eomsback.stock.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Data;

/**
 * OBE_FILE
 * @author 
 */
@Data
public class ObeFile implements Serializable {
    private String obe01;

    private String obe02;

    private String obe11;

    private BigDecimal obe12;

    private BigDecimal obe13;

    private String obe21;

    private Integer obe22;

    private BigDecimal obe23;

    private BigDecimal obe24;

    private BigDecimal obe251;

    private BigDecimal obe252;

    private BigDecimal obe253;

    private BigDecimal obe26;

    private String obe28;

    private BigDecimal obe291;

    private BigDecimal obe292;

    private BigDecimal obe293;

    private BigDecimal obe30;

    private String centre;
    private static final long serialVersionUID = 1L;
}