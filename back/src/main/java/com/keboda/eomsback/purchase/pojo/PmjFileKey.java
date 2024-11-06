package com.keboda.eomsback.purchase.pojo;

import java.io.Serializable;

import com.keboda.eomsback.entity.CommonField;
import lombok.Data;

/**
 * PMJ_FILE
 */
@Data
public class PmjFileKey extends CommonField implements Serializable {
    private String pmj01;

    private Integer pmj02;

    private String pmj10;

    private String pmj12;

    private String pmj13;

    private static final long serialVersionUID = 1L;
}