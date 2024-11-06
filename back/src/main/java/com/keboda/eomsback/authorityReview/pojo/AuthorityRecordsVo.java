package com.keboda.eomsback.authorityReview.pojo;

import lombok.Data;

@Data
public class AuthorityRecordsVo {

    private Integer uuid;

    private Integer year;

    private String positionCode;
    /**
     * 职位名
     */
    private String positionName;

    private String permissionCode;

    /**
     * 权限名
     */
    private String permissionName;

    private String isAmount;

    private String isCreate;

    private String isDelete;

    private String isUpdate;

    private String isRead;

    private String isConfirm;

    private String isUnConfirm;

    private String isVoid;

    private String isUnVoid;

    private String isPost;

    private String isUnPost;

    private String isPrint;

    private String isExport;

    private String color;

}
