package com.keboda.eomsback.flux.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.keboda.eomsback.entity.BaseResult;
import com.keboda.eomsback.flux.pojo.TaskTimeVo;
import com.keboda.eomsback.flux.pojo.RobotsTaskTime;
import com.keboda.eomsback.flux.service.IWcsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wcs")
public class WcsController {

    @Autowired
    private IWcsService iWcsService;

    @RequestMapping("/taskTimePageHelper")
    public BaseResult taskTimePageHelper(@RequestBody TaskTimeVo vo){
        PageHelper.startPage(vo.getCurrentPage(),vo.getSize());
        Page<RobotsTaskTime> page = iWcsService.taskTimePageHelper(vo);
        return BaseResult.success(page,page.getTotal());
    }
}
