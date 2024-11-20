package com.eTag.back.api.pojo;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * devices
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Devices implements Serializable {
    /**
     * 价签序列号
     */
    private String clientId;

    /**
     * 自定义名称
     */
    private String name;

    /**
     * 最近一次标签获取时间
     */
    private Date lastTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 修改用户
     */
    private String updateUser;

    /**
     * 状态
     */
    private Boolean status;

    /**
     * 创建用户
     */
    private String createUser;

    /**
     * 创建时间
     */
    private Date createTime;

    private static final long serialVersionUID = 1L;

    private Template image;

    private Template video;
}