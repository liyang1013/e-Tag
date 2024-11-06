package com.keboda.eomsback.produce.pojo;

import java.io.Serializable;

import com.keboda.eomsback.entity.CommonField;
import lombok.Data;

/**
 * 工单主键
 * SFA_FILE
 * @author
 */
@Data
public class SfaFileKey extends CommonField implements Serializable {
    private String sfa01;

    private String sfa03;

    private String sfa08;

    private String sfa12;

    private String sfa27;

    private String sfa012;

    private Integer sfa013;

    private static final long serialVersionUID = 1L;
}
