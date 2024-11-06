package com.keboda.eomsback.produce.pojo;

import java.io.Serializable;

import com.keboda.eomsback.entity.CommonField;
import lombok.Data;

/**
 * ECM_FILE
 */
@Data
public class EcmFileKey extends CommonField implements Serializable {
    private String ecm01;

    private Integer ecm03;

    private String ecm012;

    private static final long serialVersionUID = 1L;
}