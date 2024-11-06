package com.keboda.eomsback.stock.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.keboda.eomsback.entity.CommonField;
import lombok.Data;

/**
 * INA_FILE
 * @author 
 */
@Data
public class InaFile extends CommonField implements Serializable {
    private String ina01;

    private String ina00;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date ina02;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date ina03;

    private String ina04;

    private String ina05;

    private String ina06;

    private String ina07;

    private String ina08;

    private String ina09;

    private String ina10;

    private Integer inaprsw;

    private String inapost;

    private String inauser;

    private String inagrup;

    private String inamodu;

    private Date inadate;

    private String inamksg;

    private String ina11;

    private String ina1001;

    private String ina1003;

    private String ina1002;

    private String ina1004;

    private String ina1005;

    private String ina1006;

    private String ina1007;

    private String ina1008;

    private String ina1009;

    private String ina1010;

    private String ina1011;

    private String ina1012;

    private Date ina1013;

    private Date ina1014;

    private BigDecimal ina1015;

    private BigDecimal ina1016;

    private String ina1017;

    private String ina1018;

    private String ina1019;

    private BigDecimal ina1020;

    private String ina1021;

    private String ina1022;

    private String ina1023;

    private BigDecimal ina1024;

    private String ina1025;

    private String inaconf;

    private String inaspc;

    private String ina100;

    private String ina101;

    private Date ina102;

    private String inaud01;

    private String inaud02;

    private String inaud03;

    private String inaud04;

    private String inaud05;

    private String inaud06;

    private BigDecimal inaud07;

    private BigDecimal inaud08;

    private BigDecimal inaud09;

    private Long inaud10;

    private Long inaud11;

    private Long inaud12;

    private Date inaud13;

    private Date inaud14;

    private Date inaud15;

    private String ina103;

    private String ina12;

    private Date inacond;

    private String inacont;

    private String inaconu;

    private String inapos;

    private String inaplant;

    private String inalegal;

    private String inaoriu;

    private String inaorig;

    private String ina13;

    private static final long serialVersionUID = 1L;
}