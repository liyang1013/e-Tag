package com.keboda.eomsback.purchase.controller;


import com.keboda.eomsback.entity.BaseResult;
import com.keboda.eomsback.entity.SearchVo;
import com.keboda.eomsback.purchase.pojo.PmjFile;
import com.keboda.eomsback.purchase.service.IPmjService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pmj")
public class PmjController {

    @Autowired
    private IPmjService iPmjService;

    @PostMapping("/searchListByOrderCode")
    public BaseResult searchListByOrderCode(@RequestBody SearchVo searchVo){
        return BaseResult.success(iPmjService.searchListByOrderCode(searchVo));
    }

    @PostMapping("/updateInvalidityTime")
    public BaseResult updateInvalidityTime(@RequestBody PmjFile pmjFile){
        iPmjService.updateInvalidityTime(pmjFile);
        return BaseResult.success("修改成功");
    }
}
