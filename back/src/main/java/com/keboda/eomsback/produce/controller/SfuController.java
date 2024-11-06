package com.keboda.eomsback.produce.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.keboda.eomsback.entity.BaseResult;
import com.keboda.eomsback.entity.SearchVo;
import com.keboda.eomsback.produce.pojo.SfpFile;
import com.keboda.eomsback.produce.pojo.SfuFile;
import com.keboda.eomsback.produce.service.ISfuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sfu")
public class SfuController {

    @Autowired
    private ISfuService iSfuService;


    @RequestMapping("/searchSfuListPageHelper")
    public BaseResult searchSfuListPageHelper(@RequestBody SearchVo searchVo){
        PageHelper.startPage(searchVo.getCurrentPage(),searchVo.getSize());
        Page<SfuFile> page = iSfuService.searchSfuListPageHelper(searchVo);
        return BaseResult.success(page,page.getTotal());
    }

    @RequestMapping("/searchSfvList")
    public BaseResult searchSfvList(@RequestBody SearchVo searchVo){
        return BaseResult.success(iSfuService.searchSfvList(searchVo));
    }

    @RequestMapping("/updateState")
    public BaseResult updateState(@RequestBody SfuFile sfuFile){
        iSfuService.updateState(sfuFile);
        return BaseResult.success("修改成功");
    }

    @RequestMapping("/updateDate")
    public BaseResult updateDate(@RequestBody SfuFile sfuFile){
        iSfuService.updateDate(sfuFile);
        return BaseResult.success("日期修改成功");
    }

}
