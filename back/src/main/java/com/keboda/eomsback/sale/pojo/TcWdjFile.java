package com.keboda.eomsback.sale.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.keboda.eomsback.entity.CommonField;
import lombok.Data;

/**
 * TC_WDJ_FILE
 * @author 
 */
@Data
public class TcWdjFile  extends CommonField implements Serializable {
    private String cdanhao;

    private String cbarcodeno;

    private String cproduceno;

    private String cdc;

    private String chuojiano;

    private BigDecimal iqty;

    private BigDecimal ickqty;

    private Date tcWdj20;

    private String tcWdj21;

    private String tcWdj200;

    private String cflag;

    private String tcWdj51;

    private String tcWdj52;

    private String tcWdj53;

    private String tcWdj54;

    private String cwhcode;

    private static final long serialVersionUID = 1L;
}