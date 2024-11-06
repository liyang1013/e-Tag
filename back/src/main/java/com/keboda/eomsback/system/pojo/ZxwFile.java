package com.keboda.eomsback.system.pojo;

import java.io.Serializable;
import lombok.Data;

/**
 * ZXW_FILE
 */
@Data
public class ZxwFile extends ZxwFileKey implements Serializable {

    private String zxw03;

    private String zxw04;

    private String zxw05;

    private String zxw06;

    private String zxw07;

    private String zxw08;

    private static final long serialVersionUID = 1L;
}