package com.keboda.eomsback.sale.pojo;

import java.io.Serializable;

import com.keboda.eomsback.entity.CommonField;
import lombok.Data;

/**
 * OGB_FILE
 */
@Data
public class OgbFileKey extends CommonField implements Serializable {
    private String ogb01;

    private Integer ogb03;

    private static final long serialVersionUID = 1L;
}