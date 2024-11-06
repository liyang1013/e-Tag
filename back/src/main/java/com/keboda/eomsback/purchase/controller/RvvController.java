package com.keboda.eomsback.purchase.controller;

import com.keboda.eomsback.entity.BaseResult;
import com.keboda.eomsback.entity.SearchVo;
import com.keboda.eomsback.purchase.pojo.RvvFile;
import com.keboda.eomsback.purchase.service.IRvvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rvv")
public class RvvController {

    @Autowired
    private IRvvService iRvvService;


    @RequestMapping("/searchListByOrderCode")
    public BaseResult searchListByOrderCode(@RequestBody SearchVo searchVo){
        List<RvvFile> list = iRvvService.searchListByOrderCode(searchVo);
        return BaseResult.success(list);
    }
}
