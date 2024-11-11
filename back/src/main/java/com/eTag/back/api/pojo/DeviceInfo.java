package com.eTag.back.api.pojo;

import java.io.Serializable;
import lombok.Data;

/**
 * deviceinfo
 */
@Data
public class DeviceInfo implements Serializable {
    private String name;

    private String clientid;

    private String model;

    private String version;

    private Integer freespace;

    private Integer storage;

    private String ip;

    private String remarks;

    private static final long serialVersionUID = 1L;
}