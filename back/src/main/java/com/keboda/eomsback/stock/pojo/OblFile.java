package com.keboda.eomsback.stock.pojo;

import java.io.Serializable;
import lombok.Data;

/**
 * OBL_FILE
 * @author 
 */
@Data
public class OblFile extends OblFileKey implements Serializable {
    private String obl03;

    private String centre;

    private static final long serialVersionUID = 1L;
}