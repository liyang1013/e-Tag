package com.keboda.eomsback.stock.pojo;

import java.io.Serializable;
import lombok.Data;

/**
 * IMN_FILE
 */
@Data
public class ImnFileKey implements Serializable {
    private String imn01;

    private Integer imn02;

    private static final long serialVersionUID = 1L;
}