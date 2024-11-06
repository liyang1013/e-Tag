package com.keboda.eomsback.system.pojo;

import java.io.Serializable;

import com.keboda.eomsback.entity.CommonField;
import lombok.Data;

/**
 * ZXW_FILE
 */
@Data
public class ZxwFileKey extends CommonField implements Serializable {
    private String zxw01;

    private Integer zxw02;

    private static final long serialVersionUID = 1L;
}