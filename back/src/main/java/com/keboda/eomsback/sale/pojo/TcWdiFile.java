package com.keboda.eomsback.sale.pojo;

import java.io.Serializable;
import java.util.Date;

import com.keboda.eomsback.entity.CommonField;
import lombok.Data;

/**
 * TC_WDI_FILE
 * @author 
 */
@Data
public class TcWdiFile extends CommonField implements Serializable {
    private String cdanhao;

    private Date tcWdi20;

    private String tcWdi21;

    private String tcWdi200;

    private String cflag;

    private String tcWdi51;

    private String tcWdi52;

    private String tcWdi53;

    private String tcWdi54;

    private String userno;

    private Date createdate;

    private String tcWdi55;

    private String tcWdi56;

    private String tcWdi57;

    private static final long serialVersionUID = 1L;
}