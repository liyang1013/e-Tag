package com.keboda.eomsback.stock.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Data;

/**
 * IMK_FILE
 * @author 
 */
@Data
public class ImkFile extends ImkFileKey implements Serializable {
    private BigDecimal imk081;

    private BigDecimal imk082;

    private BigDecimal imk083;

    private BigDecimal imk084;

    private BigDecimal imk085;

    private BigDecimal imk086;

    private Integer imk087;

    private Integer imk088;

    private Integer imk089;

    private BigDecimal imk09;

    private String imkplant;

    private String imklegal;

    private static final long serialVersionUID = 1L;
}