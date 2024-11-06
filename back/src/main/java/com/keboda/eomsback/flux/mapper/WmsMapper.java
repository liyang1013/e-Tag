package com.keboda.eomsback.flux.mapper;

import com.github.pagehelper.Page;
import com.keboda.eomsback.entity.SearchVo;
import com.keboda.eomsback.flux.pojo.*;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

public interface WmsMapper {

    Page<InvLotLocId> invLotLocIdListPageHelper(SearchVo searchVo);

    InvLotLocId selectInvLotLocIdByKey(@Param("locationid") String locationid, @Param("lotnum") String lotnum, @Param("traceid") String traceid);

    Integer selectAsrsCount(@Param("slocation") String slocation, @Param("palletid") String palletid);

    BigDecimal checkQty(@Param("locationid") String locationid, @Param("lotnum") String lotnum, @Param("traceid") String traceid);

    InvLotAtt selectInvLotAttByKey(@Param("lotnum") String lotnum);

    InvLotAtt selectOtherStatus(InvLotAtt origin);

    Idsequence selectIdsequenceByKey(@Param("itype") String itype);

    void updateSequence(@Param("itype") String itype);

    void insertInvLotAttSelective(InvLotAtt zc);

    void updateInvLotQty(InvLot invLot);

    void insertInvLotSelective(InvLot invLot);

    InvLot selectInvLotByKey(@Param("lotnum") String lotnum);

    void updateInvLotLocIdQty(InvLotLocId invLotLocId);

    void insertInvLotLocIdSelective(InvLotLocId inv);

    RobotsStatus selectRobotsStatusByKey(@Param("id") Integer id);

    void insertRobotsStatusSelective(RobotsStatus robotsStatus);

    void updateRobotsStatusSelective(RobotsStatus robotsStatus);
}
