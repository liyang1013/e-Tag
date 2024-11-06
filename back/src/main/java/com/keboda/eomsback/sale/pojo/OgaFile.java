package com.keboda.eomsback.sale.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.keboda.eomsback.entity.CommonField;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * OGA_FILE
 */
@Data
public class OgaFile extends CommonField implements Serializable {
    private String oga01;

    private String oga00;

    private String oga011;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date oga02;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date oga021;

    private Date oga022;

    private String oga03;

    private String oga032;

    private String oga033;

    private String oga04;

    private String oga044;

    private String oga05;

    private String oga06;

    private String oga07;

    private String oga08;

    private String oga09;

    private String oga10;

    private Date oga11;

    private Date oga12;

    private String oga13;

    private String oga14;

    private String oga15;

    private String oga16;

    private Integer oga161;

    private Integer oga162;

    private Integer oga163;

    private Integer oga17;

    private String oga18;

    private String oga19;

    private String oga20;

    private String oga21;

    private BigDecimal oga211;

    private String oga212;

    private String oga213;

    private String oga23;

    private BigDecimal oga24;

    private String oga25;

    private String oga26;

    private String oga27;

    private String oga28;

    private BigDecimal oga29;

    private String oga30;

    private String oga31;

    private String oga32;

    private String oga33;

    private Integer oga34;

    private String oga35;

    private String oga36;

    private String oga37;

    private String oga38;

    private String oga39;

    private String oga40;

    private String oga41;

    private String oga42;

    private String oga43;

    private String oga44;

    private String oga45;

    private String oga46;

    private String oga47;

    private String oga48;

    private Date oga49;

    private BigDecimal oga50;

    private BigDecimal oga501;

    private BigDecimal oga51;

    private BigDecimal oga511;

    private BigDecimal oga52;

    private BigDecimal oga53;

    private BigDecimal oga54;

    private String oga99;

    private String oga901;

    private String oga902;

    private String oga903;

    private String oga904;

    private String oga905;

    private String oga906;

    private String oga907;

    private String oga908;

    private String oga909;

    private String oga910;

    private String oga911;

    private String ogaconf;

    private String ogapost;

    private Integer ogaprsw;

    private String ogauser;

    private String ogagrup;

    private String ogamodu;

    private Date ogadate;

    private String oga55;

    private String ogamksg;

    private String oga65;

    private String oga66;

    private String oga67;

    private String oga1001;

    private String oga1002;

    private String oga1003;

    private String oga1004;

    private String oga1005;

    private BigDecimal oga1006;

    private BigDecimal oga1007;

    private BigDecimal oga1008;

    private String oga1009;

    private String oga1010;

    private String oga1011;

    private String oga1012;

    private String oga1013;

    private String oga1014;

    private String oga1015;

    private String oga1016;

    private String oga68;

    private String ogaspc;

    private Date oga69;

    private String oga912;

    private Date oga913;

    private String oga914;

    private String oga70;

    private String ogaud01;

    private String ogaud02;

    private String ogaud03;

    private String ogaud04;

    private String ogaud05;

    private String ogaud06;

    private BigDecimal ogaud07;

    private BigDecimal ogaud08;

    private BigDecimal ogaud09;

    private Long ogaud10;

    private Long ogaud11;

    private Long ogaud12;

    private Date ogaud13;

    private Date ogaud14;

    private Date ogaud15;

    private String oga83;

    private String oga84;

    private String oga85;

    private String oga86;

    private String oga87;

    private String oga88;

    private String oga89;

    private String oga90;

    private String oga91;

    private String oga92;

    private String oga93;

    private String oga94;

    private BigDecimal oga95;

    private String oga96;

    private Integer oga97;

    private Date ogacond;

    private String ogaconu;

    private String ogaplant;

    private String ogalegal;

    private String oga71;

    private String ogaoriu;

    private String ogaorig;

    private String ogacont;

    private String oga98;

    private Date oga72;

    private String oga57;

    private String ogaslk01;

    private String ogaslk02;

    private String oga56;

    private static final long serialVersionUID = 1L;
}