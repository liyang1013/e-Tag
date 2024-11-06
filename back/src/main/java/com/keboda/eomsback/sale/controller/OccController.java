package com.keboda.eomsback.sale.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.keboda.eomsback.entity.BaseResult;
import com.keboda.eomsback.entity.SearchVo;
import com.keboda.eomsback.purchase.pojo.PmcFile;
import com.keboda.eomsback.sale.pojo.OccFile;
import com.keboda.eomsback.sale.service.IOccService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/occ")
public class OccController {

    @Autowired
    private IOccService iOccService;

    @PostMapping("/searchOccListPageHelper")
    public BaseResult searchOccListPageHelper(@RequestBody SearchVo searchVo){
        PageHelper.startPage(searchVo.getCurrentPage(),searchVo.getSize());
        Page<OccFile> page = iOccService.searchOccListPageHelper(searchVo);
        return BaseResult.success(page,page.getTotal());
    }
}
