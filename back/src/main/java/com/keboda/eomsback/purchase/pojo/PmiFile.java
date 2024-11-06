package com.keboda.eomsback.purchase.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.keboda.eomsback.entity.CommonField;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * PMI_FILE
 *
 * @author
 */
@Data
public class PmiFile extends CommonField implements Serializable {
    private String pmi01;


    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date pmi02;

    private String pmi03;

    private String pmi04;

    private String pmi05;

    private String pmi06;

    private String pmi07;

    private String pmiconf;

    private String pmiacti;

    private String pmiuser;

    private String pmigrup;

    private String pmimodu;

    private Date pmidate;

    private String pmi08;

    private BigDecimal pmi081;

    private String pmi09;

    private String pmi10;

    private String pmiplant;

    private String pmilegal;

    private String pmioriu;

    private String pmiorig;

    private String taPmiud01;

    private String taPmiud02;

    private String taPmiud03;

    private String taPmiud04;

    private Date taPmiud05;

    private String taPmiud06;

    private String taPmiud07;

    private String taPmiud08;

    private String taPmiud09;

    private static final long serialVersionUID = 1L;
}