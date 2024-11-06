package com.keboda.eomsback.stock.pojo;

import java.io.Serializable;
import lombok.Data;

/**
 * OBK_FILE
 * @author 
 */
@Data
public class ObkFileKey implements Serializable {
    private String obk01;

    private String obk02;

    private String obk05;

    private static final long serialVersionUID = 1L;
}