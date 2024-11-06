package com.keboda.eomsback.system.controller;

import com.keboda.eomsback.entity.BaseResult;
import com.keboda.eomsback.entity.SearchVo;
import com.keboda.eomsback.system.service.IAzfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/azf")
public class AzfController {

    @Autowired
    private IAzfService iAzfService;


    @PostMapping("/searchAzfList")
    public BaseResult searchAzfList(@RequestBody SearchVo searchVo){
        return BaseResult.success(iAzfService.searchAzfList(searchVo));
    }

    @PostMapping("/searchAzfByKey")
    public BaseResult searchAzfByKey(@RequestBody SearchVo searchVo){
        return BaseResult.success(iAzfService.searchAzfByKey(searchVo));
    }
}
