package com.keboda.eomsback.system.pojo;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.keboda.eomsback.entity.CommonField;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * ZX_FILE
 * @author 
 */
@Data
public class ZxFile extends CommonField implements Serializable {
    private String zx01;

    private String zx02;

    private String zx03;

    private String zx04;

    private String zx05;

    private String zx06;

    private String zx07;

    private String zx08;

    private String zx09;

    private String zx10;

    private String zx11;

    private String zx12;

    private String zxuser;

    private String zxgrup;

    private String zxmodu;

    private Date zxdate;

    private String zx13;

    private String zx14;

    private String zx15;

    private Date zx16;

    private String zxacti;

    private Integer zx17;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date zx18;

    private String zx19;

    private Integer zx20;

    private String zxoriu;

    private String zxorig;

    private String token;

    private String zxy03;

    private String azp02;

    private static final long serialVersionUID = 1L;
}