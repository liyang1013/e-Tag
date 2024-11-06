package com.keboda.eomsback.purchase.pojo;

import java.io.Serializable;
import lombok.Data;

/**
 * PMB_FILE
 * @author 
 */
@Data
public class PmbFileKey implements Serializable {
    private String pmb01;

    private Integer pmb03;

    private static final long serialVersionUID = 1L;
}