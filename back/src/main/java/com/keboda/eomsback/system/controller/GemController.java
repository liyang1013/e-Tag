package com.keboda.eomsback.system.controller;

import com.keboda.eomsback.entity.BaseResult;
import com.keboda.eomsback.entity.SearchVo;
import com.keboda.eomsback.stock.pojo.InaFile;
import com.keboda.eomsback.system.service.IGemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gem")
public class GemController {

    @Autowired
    private IGemService iGemService;

    @PostMapping("/searchGemList")
    public BaseResult searchGemList(@RequestBody SearchVo searchVo){
        return BaseResult.success(iGemService.searchGemList(searchVo));
    }

    @PostMapping("/searchGemByKey")
    public BaseResult searchGemByKey(@RequestBody SearchVo searchVo){
        return BaseResult.success(iGemService.searchGemByKey(searchVo));
    }
}
