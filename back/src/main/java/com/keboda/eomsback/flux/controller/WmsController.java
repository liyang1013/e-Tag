package com.keboda.eomsback.flux.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.keboda.eomsback.entity.BaseResult;
import com.keboda.eomsback.entity.SearchVo;
import com.keboda.eomsback.flux.pojo.InvLotLocId;
import com.keboda.eomsback.flux.service.IWmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/wms")
public class WmsController {

    @Autowired
    private IWmsService iWmsService;

    @RequestMapping("/invLotLocIdListPageHelper")
    public BaseResult invLotLocIdListPageHelper(@RequestBody SearchVo searchVo){
        PageHelper.startPage(searchVo.getCurrentPage(),searchVo.getSize());
        Page<InvLotLocId> page = iWmsService.invLotLocIdListPageHelper(searchVo);
        return BaseResult.success(page,page.getTotal());
    }

    @RequestMapping("/lock")
    public BaseResult lock(@RequestBody List<InvLotLocId> invLotLocIdList, String status){
        iWmsService.lock(invLotLocIdList,status);
        return BaseResult.success(status.equals("SD") ? "锁定成功" : "解锁成功");
    }
}
