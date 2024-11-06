package com.keboda.eomsback.authorityReview.pojo;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

/**
 * actionmenu
 */
@Data
public class ActionMenu implements Serializable {
    private String code;

    private String name;

    private String action;

    private String[] tags;

    private static final long serialVersionUID = 1L;
}