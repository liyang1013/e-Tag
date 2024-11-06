package com.keboda.eomsback.system.controller;

import com.keboda.eomsback.entity.BaseResult;
import com.keboda.eomsback.entity.SearchVo;
import com.keboda.eomsback.system.service.IPjaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pja")
public class PjaController {

    @Autowired
    private IPjaService iPjaService;

    @PostMapping("/searchPjaList")
    public BaseResult searchPjaList(@RequestBody SearchVo searchVo){
        return BaseResult.success(iPjaService.searchPjaList(searchVo));
    }

    @PostMapping("/searchPjaByKey")
    public BaseResult searchPjaByKey(@RequestBody SearchVo searchVo){
        return BaseResult.success(iPjaService.searchPjaByKey(searchVo));
    }
}
