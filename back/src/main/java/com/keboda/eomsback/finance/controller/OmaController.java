package com.keboda.eomsback.finance.controller;

import com.keboda.eomsback.entity.BaseResult;
import com.keboda.eomsback.entity.SearchVo;
import com.keboda.eomsback.finance.service.IOmaService;
import com.keboda.eomsback.finance.service.IOmfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/oma")
public class OmaController {

    @Autowired
    private IOmaService iOmaService;


    @RequestMapping("/selectOmbByRpa")
    public BaseResult selectOmbByRpa(@RequestBody SearchVo searchVo){
        return BaseResult.success(iOmaService.selectOmbByRpa(searchVo));
    }
}
