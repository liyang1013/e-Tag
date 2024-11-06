package com.keboda.eomsback.finance.controller;

import com.keboda.eomsback.authorityReview.pojo.ActionMenu;
import com.keboda.eomsback.entity.BaseResult;
import com.keboda.eomsback.entity.SearchVo;
import com.keboda.eomsback.finance.service.IOmfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/omf")
public class OmfController {

    @Autowired
    private IOmfService iOmfService;

    @RequestMapping("/selectOmfByRpa")
    public BaseResult selectOmfByRpa(@RequestBody SearchVo searchVo){
        return BaseResult.success(iOmfService.selectOmfByRpa(searchVo));
    }
}
