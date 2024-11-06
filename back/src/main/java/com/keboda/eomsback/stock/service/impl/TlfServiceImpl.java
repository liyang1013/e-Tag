package com.keboda.eomsback.stock.service.impl;

import com.github.pagehelper.Page;
import com.keboda.eomsback.entity.SearchVo;
import com.keboda.eomsback.stock.mapper.TlfFileMapper;
import com.keboda.eomsback.stock.pojo.EWStockGap;
import com.keboda.eomsback.stock.service.ITlfService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;

@Service
public class TlfServiceImpl implements ITlfService {

    @Resource
    private TlfFileMapper tlfFileMapper;

    @Override
    public Page<EWStockGap> searchEWStockGapPageHelper(SearchVo searchVo) {
        return tlfFileMapper.searchEWStockGapPageHelper(searchVo);
    }

    /**
     * 批量更新异动日期
     *
     * @param centre 中心
     * @param tlf026 单据号
     * @param tlf036 单据号
     * @param ddate  日期
     * @param tlf907 异动类型
     */
    @Override
    @Transactional
    public void alterByCode(String centre, String tlf026, String tlf036, String tlf907, Date ddate,String tlf19,String tlf20) {
        tlfFileMapper.alterByCode(centre, tlf026, tlf036,tlf907, ddate,tlf19,tlf20);
    }

    /**
     * 按行更新tlf异动数量
     *
     * @param centre 中心
     * @param tlf026 单据号
     * @param tlf027 单据项次
     * @param tlf036 单据号
     * @param tlf037 单据项次
     * @param tlf10  异动数量
     */
    @Override
    @Transactional
    public void alterByRow(String centre, String tlf026, Integer tlf027, String tlf036, Integer tlf037, BigDecimal tlf10,String tlf14,String tlf41) {
        tlfFileMapper.alterByRow(centre, tlf026, tlf027, tlf036, tlf037, tlf10, tlf14, tlf41);
    }
}
