package com.eTag.back.api.pojo;

import java.io.Serializable;
import lombok.Data;

/**
 * view
 */
@Data
public class View implements Serializable {
    private Integer id;

    /**
     * 名称
     */
    private String name;

    private String path;

    private String component;

    private String icon;

    private Integer sort;

    private static final long serialVersionUID = 1L;
}