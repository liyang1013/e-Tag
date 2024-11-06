package com.keboda.eomsback.produce.pojo;

import java.io.Serializable;

import com.keboda.eomsback.entity.CommonField;
import lombok.Data;

/**
 * SFS_FILE
 */
@Data
public class SfsFileKey extends CommonField implements Serializable {
    private String sfs01;

    private Integer sfs02;

    private static final long serialVersionUID = 1L;
}