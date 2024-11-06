package com.keboda.eomsback.system.pojo;

import lombok.Data;

@Data
public class Authority {

    private Integer index;

    private String zw01;

    private String zw02;

    private String zy02;

    private String gaz03;

    private String includeAmount;

    private String includeAdd;

    private String includeQuery;

    private String includeModify;

    private String includeDelete;

    private String includeConfirm;

    private String includeUndoConfirm;

    private String includeRelease;

    private String includeUnRelease;

    private String includeBlank;

    private String includePost;

    private String includeUndoPost;

    private String includeInvoiceexport;

    private String includePrint;

}
