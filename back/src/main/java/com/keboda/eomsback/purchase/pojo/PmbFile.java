package com.keboda.eomsback.purchase.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * PMB_FILE
 * @author 
 */
@Data
public class PmbFile extends PmbFileKey implements Serializable {
    private String pmb02;

    private String pmb04;

    private BigDecimal pmb05;

    private String pmb06;

    private String pmb07;

    private String pmbacti;

    private String pmbuser;

    private String pmbgrup;

    private String pmbmodu;

    private Date pmbdate;

    private String pmborig;

    private String pmboriu;

    private static final long serialVersionUID = 1L;
}