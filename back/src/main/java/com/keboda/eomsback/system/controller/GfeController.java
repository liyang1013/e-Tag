package com.keboda.eomsback.system.controller;

import com.keboda.eomsback.entity.BaseResult;
import com.keboda.eomsback.entity.SearchVo;
import com.keboda.eomsback.system.service.IGfeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gfe")
public class GfeController {


    @Autowired
    private IGfeService iGfeService;

    @PostMapping("/searchGfeList")
    public BaseResult searchGfeList(@RequestBody SearchVo searchVo){
        return BaseResult.success(iGfeService.searchGfeList(searchVo));
    }

    @PostMapping("/searchGfeByKey")
    public BaseResult searchGfeByKey(@RequestBody SearchVo searchVo){
        return BaseResult.success(iGfeService.searchGfeByKey(searchVo));
    }

}
