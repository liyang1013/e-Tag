package com.keboda.eomsback.sale.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * TC_WDJA_FILE
 * @author 
 */
@Data
public class TcWdjaFile implements Serializable {
    private String cdanhao;

    private String cbarcodeno;

    private String cproduceno;

    private String cdc;

    private String cwhcode;

    private String cpalletno;

    private BigDecimal iqty;

    private String fullpalflag;

    private String qcsta;

    private BigDecimal port;

    private Date tcWdja20;

    private String tcWdja21;

    private String tcWdja200;

    private String cflag;

    private String tcWdja51;

    private String tcWdja52;

    private String tcWdja53;

    private String tcWdja54;

    private BigDecimal ickqty;

    private BigDecimal id;

    private static final long serialVersionUID = 1L;
}