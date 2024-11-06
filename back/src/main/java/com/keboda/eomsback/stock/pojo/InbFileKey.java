package com.keboda.eomsback.stock.pojo;

import java.io.Serializable;

import com.keboda.eomsback.entity.CommonField;
import lombok.Data;

/**
 * INB_FILE
 * @author 
 */
@Data
public class InbFileKey extends CommonField implements Serializable {
    private String inb01;

    private Integer inb03;

    private static final long serialVersionUID = 1L;
}