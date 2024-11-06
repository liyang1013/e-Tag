package com.keboda.eomsback.stock.controller;

import com.keboda.eomsback.entity.BaseResult;
import com.keboda.eomsback.entity.SearchVo;
import com.keboda.eomsback.stock.service.IImdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/imd")
public class ImdController {

    @Autowired
    private IImdService iImdService;

    @RequestMapping("/searchImdList")
    public BaseResult searchImdList(@RequestBody SearchVo searchVo){
        return BaseResult.success(iImdService.searchImdList(searchVo));
    }
}
