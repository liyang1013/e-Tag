package com.keboda.eomsback.purchase.pojo;

import java.io.Serializable;

import com.keboda.eomsback.entity.CommonField;
import lombok.Data;

/**
 * RVV_FILE
 * @author 
 */
@Data
public class RvvFileKey extends CommonField implements Serializable {
    private String rvv01;

    private Integer rvv02;

    private static final long serialVersionUID = 1L;
}