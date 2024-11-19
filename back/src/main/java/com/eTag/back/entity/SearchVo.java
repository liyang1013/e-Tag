package com.eTag.back.entity;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * 查询通用Vo，带分页
 */
@Data
public class SearchVo {

    private String code;

    private String name;

    private Boolean status;

    private Integer currentPage = 1;

    private Integer size = 20;

    private Integer total;

}
