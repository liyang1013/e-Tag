package com.keboda.eomsback.sale.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.keboda.eomsback.entity.BaseResult;
import com.keboda.eomsback.entity.SearchVo;
import com.keboda.eomsback.sale.pojo.OhaFile;
import com.keboda.eomsback.sale.pojo.OhbFile;
import com.keboda.eomsback.sale.service.IOhaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/oha")
public class OhaController {

    @Autowired
    private IOhaService iOhaService;


    @RequestMapping("/searchOhaListPageHelper")
    public BaseResult searchOhaListPageHelper(@RequestBody SearchVo searchVo){
        PageHelper.startPage(searchVo.getCurrentPage(),searchVo.getSize());
        Page<OhaFile> page = iOhaService.searchOhaListPageHelper(searchVo);
        return BaseResult.success(page,page.getTotal());
    }

    @RequestMapping("/searchOhbList")
    public BaseResult searchOhbList(@RequestBody SearchVo searchVo){
        List<OhbFile> list = iOhaService.searchOhbList(searchVo);
        return BaseResult.success(list);
    }

    @PostMapping("/alterOhaDate")
    public BaseResult alterOgaDate(@RequestBody OhaFile ohaFile){
        iOhaService.alterOhaDate(ohaFile);
        return BaseResult.success("销退日期修改成功");
    }
}
