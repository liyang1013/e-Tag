package com.keboda.eomsback.system.controller;

import com.keboda.eomsback.entity.BaseResult;
import com.keboda.eomsback.system.service.IZwService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/zw")
public class ZwController {

    @Autowired
    private IZwService iZwService;


    @RequestMapping("/searchZwList")
    public BaseResult searchZwList(String query){
        return BaseResult.success(iZwService.searchZwList(query));
    }
}
