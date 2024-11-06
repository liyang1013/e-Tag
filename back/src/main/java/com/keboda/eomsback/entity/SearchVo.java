package com.keboda.eomsback.entity;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * 查询通用Vo，带分页
 */
@Data
public class SearchVo {

    private String code;

    private String originCode;

    private String sfb;

    private String no;

    private String[] codes;

    private Integer year;

    private String pmc;

    private String occ;

    private String ima;

    private String batch;

    private String multiTradeCode;

    private String imd;

    private String zx;

    private String gem;

    private String gaz;

    private String eci;

    private String gaz04;

    private String azf;

    private String azf02;

    private String azf09;

    private String gfe;

    private String pja;

    private String pjb;

    private String centre;

    private Date startdate;

    private Date enddate;

    private String acti = "Y";

    private String conf = "Y";

    private String status;

    private Boolean flag;

    private String pallet;

    private Integer currentPage = 1;

    private Integer size = 20;

    private Integer total;

    private Integer itype;
}
