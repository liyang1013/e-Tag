package com.keboda.eomsback.system.controller;

import com.keboda.eomsback.entity.BaseResult;
import com.keboda.eomsback.entity.SearchVo;
import com.keboda.eomsback.system.service.IPjbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pjb")
public class PjbController {

    @Autowired
    private IPjbService iPjbService;

    @PostMapping("/searchPjbList")
    public BaseResult searchPjbList(@RequestBody SearchVo searchVo){
        return BaseResult.success(iPjbService.searchPjbList(searchVo));
    }

    @PostMapping("/searchPjbByKey")
    public BaseResult searchPjbByKey(@RequestBody SearchVo searchVo){
        return BaseResult.success(iPjbService.searchPjbByKey(searchVo));
    }
}
