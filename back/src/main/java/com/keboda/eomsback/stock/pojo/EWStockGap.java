package com.keboda.eomsback.stock.pojo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class EWStockGap {

    private String cdanhao;

    private String cproduceno;

    private String cproducename;

    private String cwhcode;

    private BigDecimal iqty;

    private BigDecimal qty;

    private String imd02;

    private BigDecimal gapqty;
}
