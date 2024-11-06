package com.keboda.eomsback.sale.pojo;

import java.io.Serializable;

import com.keboda.eomsback.entity.CommonField;
import lombok.Data;

/**
 * OHB_FILE
 */
@Data
public class OhbFileKey extends CommonField implements Serializable {
    private String ohb01;

    private Integer ohb03;

    private static final long serialVersionUID = 1L;
}