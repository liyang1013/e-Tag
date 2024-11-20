package com.eTag.back.api.pojo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * template
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Template implements Serializable {
    /**
     * 唯一主键
     */
    private String uuid;

    private Integer x;

    private Integer y;

    private Integer width;

    private Integer height;

    private String name;

    private String md5;

    private String type;

    private String clientId;

    private static final long serialVersionUID = 1L;
}