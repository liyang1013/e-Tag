package com.keboda.eomsback.finance.pojo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Map;

@Data
public class RpaVo {

    private BigDecimal num;

    private BigDecimal amount;

    private BigDecimal tax;

    private Map<String, BigDecimal> materialNum;
}
