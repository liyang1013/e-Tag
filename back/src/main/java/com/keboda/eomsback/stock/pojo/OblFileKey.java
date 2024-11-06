package com.keboda.eomsback.stock.pojo;

import java.io.Serializable;
import lombok.Data;

/**
 * OBL_FILE
 * @author 
 */
@Data
public class OblFileKey implements Serializable {
    private String obl01;

    private String obl02;

    private static final long serialVersionUID = 1L;
}