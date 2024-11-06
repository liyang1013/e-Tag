package com.keboda.eomsback.purchase.pojo;

import java.io.Serializable;
import java.util.Date;

import com.keboda.eomsback.entity.CommonField;
import lombok.Data;

/**
 * PMY_FILE
 * @author 
 */
@Data
public class PmyFile implements Serializable {
    private String pmy01;

    private String pmy02;

    private String pmy03;

    private String pmy04;

    private String pmy05;

    private String pmy06;

    private String pmy07;

    private String pmy08;

    private String pmy09;

    private String pmy10;

    private String pmyacti;

    private String pmyuser;

    private String pmygrup;

    private String pmymodu;

    private Date pmydate;

    private String pmyorig;

    private String pmyoriu;

    private static final long serialVersionUID = 1L;
}