package com.keboda.eomsback.stock.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.keboda.eomsback.entity.BaseResult;
import com.keboda.eomsback.entity.SearchVo;
import com.keboda.eomsback.purchase.pojo.RvaFile;
import com.keboda.eomsback.stock.pojo.InaFile;
import com.keboda.eomsback.stock.pojo.InbFile;
import com.keboda.eomsback.stock.service.IInaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ina")
public class InaController {

    @Autowired
    private IInaService iInaService;

    @PostMapping("/searchListPageHelper")
    public BaseResult searchListPageHelper(@RequestBody SearchVo searchVo){
        PageHelper.startPage(searchVo.getCurrentPage(),searchVo.getSize());
        Page<InaFile> page = iInaService.searchListPageHelper(searchVo);
        return BaseResult.success(page,page.getTotal());
    }

    @PostMapping("/searchSlaveList")
    public BaseResult searchSlaveList(@RequestBody SearchVo searchVo){
        return BaseResult.success(iInaService.searchSlaveList(searchVo));
    }

    @PostMapping("/alterGem")
    public BaseResult alterGem(@RequestBody InaFile inaFile){
        iInaService.alterGem(inaFile);
        return BaseResult.success("修改部门成功");
    }

    @PostMapping("/alterAzf")
    public BaseResult alterAzf(@RequestBody InbFile inbFile){
        iInaService.alterAzf(inbFile);
        return BaseResult.success("修改理由码成功");
    }

    @PostMapping("/alterPja")
    public BaseResult alterPja(@RequestBody InaFile inaFile){
        iInaService.alterPja(inaFile);
        return BaseResult.success("修改专案编号成功");
    }

    @PostMapping("/alterPjb")
    public BaseResult alterPjb(@RequestBody InbFile inbFile){
        iInaService.alterPjb(inbFile);
        return BaseResult.success("修改WBS成功");
    }

    @RequestMapping("/alterConf")
    public BaseResult alterConf(@RequestBody InaFile inaFile){
        iInaService.alterConf(inaFile);
        return BaseResult.success("修改状态成功");
    }
}
