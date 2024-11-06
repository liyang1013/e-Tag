package com.keboda.eomsback.stock.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.keboda.eomsback.entity.CommonField;
import lombok.Data;

/**
 * IMM_FILE
 * @author 
 */
@Data
public class ImmFile extends CommonField implements Serializable {
    private String imm01;

    private Date imm02;

    private String imm03;

    private String imm04;

    private Integer immdays;

    private Integer immprit;

    private Integer imm05;

    private Integer imm06;

    private Integer imm07;

    private String imm08;

    private String imm09;

    private String imm10;

    private String imm11;

    private Date imm12;

    private String imm13;

    private String immacti;

    private String immuser;

    private String immgrup;

    private String immmodu;

    private Date immdate;

    private String immconf;

    private String imm14;

    private String immspc;

    private String immud01;

    private String immud02;

    private String immud03;

    private String immud04;

    private String immud05;

    private String immud06;

    private BigDecimal immud07;

    private BigDecimal immud08;

    private BigDecimal immud09;

    private Long immud10;

    private Long immud11;

    private Long immud12;

    private Date immud13;

    private Date immud14;

    private Date immud15;

    private String immplant;

    private String immlegal;

    private String immoriu;

    private String immorig;

    private String imm15;

    private String imm16;

    private String immmksg;

    private Date imm17;

    private static final long serialVersionUID = 1L;
}