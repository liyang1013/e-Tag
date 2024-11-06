package com.keboda.eomsback.authorityReview.pojo;

import java.io.Serializable;
import lombok.Data;

/**
 * personalposition
 */
@Data
public class PersonalPosition implements Serializable {

    private Integer uuid;
    /**
     * 员工工号
     */
    private String code;

    /**
     * 年度
     */
    private Integer year;

    /**
     * 姓名
     */
    private String name;

    /**
     * 1 职位、2 作业代码
     */
    private Integer itype;

    /**
     * 权限、作业代码
     */
    private String permissionCode;

    /**
     * 权限、作业名称
     */
    private String permissionName;

    private String zx04;

    private String zw02;

    private String color;

    private static final long serialVersionUID = 1L;
}