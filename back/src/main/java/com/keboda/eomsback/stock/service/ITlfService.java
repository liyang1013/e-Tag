package com.keboda.eomsback.stock.service;

import com.github.pagehelper.Page;
import com.keboda.eomsback.entity.SearchVo;
import com.keboda.eomsback.stock.pojo.EWStockGap;

import java.math.BigDecimal;
import java.util.Date;

public interface ITlfService {
    Page<EWStockGap> searchEWStockGapPageHelper(SearchVo searchVo);

    void alterByCode(String centre, String tlf026, String tlf036, String tlf907, Date ddate,String tlf19,String tlf20);

    void alterByRow(String centre, String tlf026, Integer tlf027, String tlf036, Integer tlf037, BigDecimal tlf10,String tlf14,String tlf41);
}
