package com.keboda.eomsback.purchase.controller;

import com.keboda.eomsback.entity.BaseResult;
import com.keboda.eomsback.entity.SearchVo;
import com.keboda.eomsback.purchase.service.IPmlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pml")
public class PmlController {

    @Autowired
    private IPmlService iPmlService;

    @PostMapping("/searchListByOrderCode")
    public BaseResult searchListByOrderCode(@RequestBody SearchVo searchVo){
        return BaseResult.success(iPmlService.searchListByOrderCode(searchVo));
    }
}
