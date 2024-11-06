package com.keboda.eomsback.finance.pojo;

import java.io.Serializable;
import lombok.Data;

/**
 * OMB_FILE
 */
@Data
public class OmbFileKey implements Serializable {
    private String omb01;

    private Integer omb03;

    private static final long serialVersionUID = 1L;
}