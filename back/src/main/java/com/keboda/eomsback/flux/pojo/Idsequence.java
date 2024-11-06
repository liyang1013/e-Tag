package com.keboda.eomsback.flux.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class Idsequence implements Serializable {

    private String itype;

    private String prefix;

    private String idsequence;

    private Integer length;

    private String dateformat;

    private static final long serialVersionUID = 1L;
}
