package com.keboda.eomsback.authorityReview.pojo;

import java.io.Serializable;
import lombok.Data;

/**
 * 权限表
 * permission
 */
@Data
public class Permission implements Serializable {
    /**
     * uuid
     */
    private Integer uuid;

    private String positionCode;
    /**
     * 职位名
     */
    private String positionName;

    /**
     * 权限编码
     */
    private String permissionCode;

    /**
     * 权限名
     */
    private String permissionName;

    private Boolean containAmount;

    private Boolean containCreate;

    private Boolean containDelete;

    private Boolean containUpdate;

    private Boolean containRead;

    private Boolean containConfirm;

    private Boolean containUnConfirm;

    private Boolean containVoid;

    private Boolean containUnVoid;

    private Boolean containPost;

    private Boolean containUnPost;

    private Boolean containPrint;

    private Boolean containExport;

    private static final long serialVersionUID = 1L;
}