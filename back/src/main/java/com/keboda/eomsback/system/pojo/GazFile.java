package com.keboda.eomsback.system.pojo;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * GAZ_FILE
 * @author 
 */
@Data
public class GazFile extends GazFileKey implements Serializable {
    private String gaz03;

    private String gaz04;

    private String gazuser;

    private String gazgrup;

    private String gazmodu;

    private Date gazdate;

    private String gaz06;

    private String gazorig;

    private String gazoriu;

    private static final long serialVersionUID = 1L;
}