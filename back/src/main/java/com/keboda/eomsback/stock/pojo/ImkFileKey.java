package com.keboda.eomsback.stock.pojo;

import java.io.Serializable;
import lombok.Data;

/**
 * IMK_FILE
 * @author 
 */
@Data
public class ImkFileKey implements Serializable {
    private String imk01;

    private String imk02;

    private String imk03;

    private String imk04;

    private Integer imk05;

    private Integer imk06;

    private static final long serialVersionUID = 1L;
}