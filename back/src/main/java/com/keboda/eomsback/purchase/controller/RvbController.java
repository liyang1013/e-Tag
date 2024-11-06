package com.keboda.eomsback.purchase.controller;

import com.keboda.eomsback.entity.BaseResult;
import com.keboda.eomsback.entity.SearchVo;
import com.keboda.eomsback.purchase.pojo.RvbFile;
import com.keboda.eomsback.purchase.service.IRvbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/rvb")
@RestController
public class RvbController {

    @Autowired
    private IRvbService iRvbService;

    @RequestMapping("/searchListByOrderCode")
    public BaseResult searchListByOrderCode(@RequestBody SearchVo searchVo){
        List<RvbFile> list = iRvbService.searchListByOrderCode(searchVo);
        return BaseResult.success(list);
    }

}
