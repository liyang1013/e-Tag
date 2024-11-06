package com.keboda.eomsback.finance.pojo;

import java.io.Serializable;
import lombok.Data;

/**
 * OMF_FILE
 */
@Data
public class OmfFileKey implements Serializable {
    private String omf00;

    private Integer omf21;

    private static final long serialVersionUID = 1L;
}