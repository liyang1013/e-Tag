package com.keboda.eomsback.system.pojo;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * GFE_FILE
 * @author 
 */
@Data
public class GfeFile implements Serializable {
    private String gfe01;

    private String gfe02;

    private Integer gfe03;

    private String gfeacti;

    private String gfeuser;

    private String gfegrup;

    private String gfemodu;

    private Date gfedate;

    private String gfepos;

    private String gfeorig;

    private String gfeoriu;

    private static final long serialVersionUID = 1L;
}