package com.keboda.eomsback.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CommonField {

    /**
     * 中心
     */
    private String centre;

    private String zx02;

    private String zw02;

    /**
     * 仓库
     */
    private String imd02;

    /**
     * 料件名称
     */
    private String ima02;

    /**
     * 料件规格
     */
    private String ima021;

    /**
     * 库存单位
     */
    private String ima25;

    /**
     * 采购单位
     */
    private String ima44;


    /**
     * 供应商
     */
    private String pmc03;

    private String pja02;

    /**
     * 供应商分类
     */
    private String pmy02;

    private String oca02;

    /**
     * 付款方式
     */
    private String pma02;

    /**
     * 价格条件
     */
    private String pnz02;

    /**
     * 客户
     */
    private String occ02;

    private String gem01;
    /**
     * 部门
     */
    private String gem02;

    /**
     * 人员
     */
    private String gen02;

    /**
     * 单别
     */
    private String smydesc;

    private String gee06;

    private String gee05;


    /**
     * 自定义flux出库数量
     */
    private BigDecimal fickqty;

}
