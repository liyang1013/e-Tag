package com.eTag.back.api.pojo;

import lombok.Data;

@Data
public class Video {

    private Integer VideoNo;

    private String VideoUrl;

    private String VideoMD5;

    private String VideoName;
}
