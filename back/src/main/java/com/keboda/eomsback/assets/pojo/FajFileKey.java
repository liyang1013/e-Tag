package com.keboda.eomsback.assets.pojo;

import java.io.Serializable;

import com.keboda.eomsback.entity.CommonField;
import lombok.Data;

/**
 * FAJ_FILE
 */
@Data
public class FajFileKey extends CommonField implements Serializable {
    private String faj01;

    private String faj02;

    private String faj022;

    private static final long serialVersionUID = 1L;
}