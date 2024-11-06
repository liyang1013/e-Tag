package com.keboda.eomsback.stock.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * TC_WIA_FILE
 */
@Data
public class TcWiaFile implements Serializable {
    private String cbarcodeno;

    private String cboxid;

    private String cpalletno;

    private String cproduceno;

    private String cproducename;

    private String cguige;

    private String cwhcode;

    private String chuojiano;

    private String cgys;

    private BigDecimal iqty;

    private BigDecimal iqtySl;

    private BigDecimal iqtyRk;

    private BigDecimal iqtyJh;

    private BigDecimal iqtyCk;

    private String cdc;

    private BigDecimal iycdays;

    private String clotno;

    private String lockflag;

    private String tcWia106;

    private Date tcWia20;

    private String tcWia21;

    private String tcWia51;

    private String tcWia52;

    private String tcWia53;

    private BigDecimal tcWia54;

    private String remark;

    private String tcWia55;

    private String tcWia56;

    private String tcWia57;

    private String tcWia58;

    private String tcWia59;

    private String tcWia60;

    /**
     * 辅条码
     */
    private String tcWia22;

    private String tcWia23;

    private String tcWia24;

    private String tcWia25;

    private String tcWia26;

    private String tcWia27;

    private String tcWia28;

    private BigDecimal tcWia29;

    private BigDecimal tcWia30;

    private BigDecimal tcWia31;

    private String tcWia32;

    private String tcWia33;

    private String tcWia34;

    private String tcWia35;

    private String crtype;

    private BigDecimal qty;

    private String imd02;

    private BigDecimal gapqty;

    private static final long serialVersionUID = 1L;
}