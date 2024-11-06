package com.keboda.eomsback.flux.service;

import com.github.pagehelper.Page;
import com.keboda.eomsback.entity.SearchVo;
import com.keboda.eomsback.flux.pojo.InvLotLocId;
import com.keboda.eomsback.flux.pojo.RobotsStatus;

import java.util.List;

public interface IWmsService {

    RobotsStatus selectRobotsStatusByKey(Integer id);

    void insertRobotsStatusSelective(RobotsStatus robotsStatus);

    void updateRobotsStatusSelective(RobotsStatus robotsStatus);

    Page<InvLotLocId> invLotLocIdListPageHelper(SearchVo searchVo);

    void lock(List<InvLotLocId> invLotLocIdList, String status);
}
