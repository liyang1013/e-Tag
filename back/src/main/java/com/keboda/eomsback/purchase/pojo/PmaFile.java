package com.keboda.eomsback.purchase.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * PMA_FILE
 * @author 
 */
@Data
public class PmaFile implements Serializable {
    private String pma01;

    private String pma02;

    private String pma03;

    private BigDecimal pma04;

    private Integer pma05;

    private BigDecimal pma06;

    private BigDecimal pma07;

    private Integer pma08;

    private Integer pma09;

    private Integer pma10;

    private String pma11;

    private String pma12;

    private Integer pma13;

    private String pmaacti;

    private String pmauser;

    private String pmagrup;

    private String pmamodu;

    private Date pmadate;

    private String pmaorig;

    private String pmaoriu;

    private static final long serialVersionUID = 1L;
}