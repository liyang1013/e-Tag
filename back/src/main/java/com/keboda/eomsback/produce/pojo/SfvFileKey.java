package com.keboda.eomsback.produce.pojo;

import java.io.Serializable;

import com.keboda.eomsback.entity.CommonField;
import lombok.Data;

/**
 * SFV_FILE
 */
@Data
public class SfvFileKey extends CommonField implements Serializable {
    private String sfv01;

    private Integer sfv03;

    private static final long serialVersionUID = 1L;
}