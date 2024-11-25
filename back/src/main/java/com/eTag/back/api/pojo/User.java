package com.eTag.back.api.pojo;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * user
 */
@Data
public class User implements Serializable {
    private Integer uid;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String passwd;

    /**
     * 上次登入时间
     */
    private Date lastLoginTime;

    /**
     * 登入地址
     */
    private Integer ipAddress;

    /**
     * 用户许可
     */
    private String appid;

    /**
     * 状态
     */
    private Boolean status;


    private String appSecret;


    private Date licenseTime;

    private static final long serialVersionUID = 1L;
}