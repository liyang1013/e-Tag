package com.eTag.back.api.pojo;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date lastTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 修改用户
     */
    private Integer updateUser;

    /**
     * 状态
     */
    private Boolean status;

    /**
     * 创建用户
     */
    private Integer createUser;

    /**
     * 创建时间
     */
    private Date createTime;

    private static final long serialVersionUID = 1L;

    private Template image;

    private Template video;

    private Integer nlast;

    private String username;
}