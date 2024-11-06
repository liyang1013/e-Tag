package com.keboda.eomsback.purchase.pojo;

import java.io.Serializable;

import com.keboda.eomsback.entity.CommonField;
import lombok.Data;

/**
 * RVB_FILE
 * @author 
 */
@Data
public class RvbFileKey extends CommonField implements Serializable {
    private String rvb01;

    private Integer rvb02;

    private static final long serialVersionUID = 1L;
}