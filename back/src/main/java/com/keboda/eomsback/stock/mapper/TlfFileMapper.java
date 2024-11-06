package com.keboda.eomsback.stock.mapper;

import com.github.pagehelper.Page;
import com.keboda.eomsback.entity.SearchVo;
import com.keboda.eomsback.stock.pojo.EWStockGap;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface TlfFileMapper {
    Page<EWStockGap> searchEWStockGapPageHelper(SearchVo searchVo);

    /**
     *
     * @param centre 中心
     * @param tlf026 源单号
     * @param tlf036 目的单号
     * @param ddate 异动日期
     * @param tlf907 异动类型 出库:-1,入库: 1
     * @param tlf19 部门
     * @param tlf20 项目
     */
    void alterByCode(@Param("centre") String centre, @Param("tlf026") String tlf026, @Param("tlf036") String tlf036, @Param("tlf907") String tlf907, @Param("ddate") Date ddate,@Param("tlf19") String tlf19,@Param("tlf20") String tlf20);

    /**
     *
     * @param centre 中心
     * @param tlf026 源单号
     * @param tlf027 源行号
     * @param tlf036 目的单号
     * @param tlf037 目的行号
     * @param tlf10 异动数量
     * @param tlf14 异动原因码
     * @param tlf41 WBS编码
     */
    void alterByRow( @Param("centre")String centre,  @Param("tlf026")String tlf026,  @Param("tlf027")Integer tlf027,  @Param("tlf036")String tlf036,  @Param("tlf037")Integer tlf037, @Param("tlf10")BigDecimal tlf10,@Param("tlf14") String tlf14, @Param("tlf41") String tlf41);

}
