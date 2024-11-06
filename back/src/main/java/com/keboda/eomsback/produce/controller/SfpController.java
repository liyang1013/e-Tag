package com.keboda.eomsback.produce.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.keboda.eomsback.entity.BaseResult;
import com.keboda.eomsback.entity.SearchVo;
import com.keboda.eomsback.produce.pojo.SfbFile;
import com.keboda.eomsback.produce.pojo.SfpFile;
import com.keboda.eomsback.produce.pojo.SfsFile;
import com.keboda.eomsback.produce.service.ISfpService;
import com.keboda.eomsback.purchase.pojo.RvaFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sfp")
public class SfpController {

    @Autowired
    private ISfpService iSfpService;

    @RequestMapping("/searchListPageHelper")
    public BaseResult searchListPageHelper(@RequestBody SearchVo searchVo){
        PageHelper.startPage(searchVo.getCurrentPage(),searchVo.getSize());
        Page<SfpFile> page = iSfpService.searchListPageHelper(searchVo);
        return BaseResult.success(page,page.getTotal());
    }

    @RequestMapping("/searchSlaveList")
    public BaseResult searchSlaveList(@RequestBody SearchVo searchVo){
        return BaseResult.success(iSfpService.searchSlaveList(searchVo));
    }

    @RequestMapping("/updateState")
    public BaseResult updateState(@RequestBody SfpFile sfpFile){
        iSfpService.updateState(sfpFile);
        return BaseResult.success("修改成功");
    }

    @RequestMapping("/updateUnit")
    public BaseResult updateUnit(@RequestBody SfsFile sfsFile){
        iSfpService.updateUnit(sfsFile);
        return BaseResult.success("修改成功");
    }

    @RequestMapping("/updateDate")
    public BaseResult updateDate(@RequestBody SfpFile sfpFile){
        iSfpService.updateDate(sfpFile);
        return BaseResult.success("日期修改成功");
    }
}
