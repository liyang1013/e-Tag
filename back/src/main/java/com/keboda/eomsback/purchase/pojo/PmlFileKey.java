package com.keboda.eomsback.purchase.pojo;

import java.io.Serializable;

import com.keboda.eomsback.entity.CommonField;
import lombok.Data;

/**
 * PML_FILE
 * @author 
 */
@Data
public class PmlFileKey extends CommonField implements Serializable {
    private String pml01;

    private Integer pml02;

    private static final long serialVersionUID = 1L;
}