package com.keboda.eomsback.system.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.keboda.eomsback.entity.BaseResult;
import com.keboda.eomsback.entity.SearchVo;
import com.keboda.eomsback.system.pojo.GazFile;
import com.keboda.eomsback.system.service.IGazService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gaz")
public class GazController {

    @Autowired
    private IGazService iGazService;

    @RequestMapping("/searchGazListPageHelper")
    public BaseResult searchGazListPageHelper(@RequestBody SearchVo searchVo){
        PageHelper.startPage(searchVo.getCurrentPage(),searchVo.getSize());
        Page<GazFile> page = iGazService.searchGazListPageHelper(searchVo);
        return BaseResult.success(page,page.getTotal());
    }
}
