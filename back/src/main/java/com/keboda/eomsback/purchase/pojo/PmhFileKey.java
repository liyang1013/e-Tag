package com.keboda.eomsback.purchase.pojo;

import java.io.Serializable;

import com.keboda.eomsback.entity.CommonField;
import lombok.Data;

/**
 * PMH_FILE
 * @author 
 */
@Data
public class PmhFileKey extends CommonField implements Serializable {
    private String pmh01;

    private String pmh02;

    private String pmh13;

    private String pmh21;

    private String pmh22;

    private String pmh23;

    private static final long serialVersionUID = 1L;
}