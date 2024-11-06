package com.keboda.eomsback.produce.controller;

import com.keboda.eomsback.entity.BaseResult;
import com.keboda.eomsback.entity.SearchVo;
import com.keboda.eomsback.produce.service.IEciService;
import com.keboda.eomsback.system.service.IGemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/eci")
public class EciController {

    @Autowired
    private IEciService iEciService;

    @PostMapping("/searchEciList")
    public BaseResult searchEciList(@RequestBody SearchVo searchVo){
        return BaseResult.success(iEciService.searchEciList(searchVo));
    }

    @PostMapping("/searchEciByKey")
    public BaseResult searchEciByKey(@RequestBody SearchVo searchVo){
        return BaseResult.success(iEciService.searchEciByKey(searchVo));
    }
}
