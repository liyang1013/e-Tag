package com.keboda.eomsback.sale.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.keboda.eomsback.entity.BaseResult;
import com.keboda.eomsback.entity.SearchVo;
import com.keboda.eomsback.sale.pojo.TcWdiFile;
import com.keboda.eomsback.sale.pojo.TcWdjFile;
import com.keboda.eomsback.sale.service.IWdiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/wdi")
@RestController
public class WdiController {

    @Autowired
    private IWdiService iWdiService;

    @RequestMapping("/searchWdiListPageHelper")
    public BaseResult searchWdiListPageHelper(@RequestBody SearchVo searchVo){
        PageHelper.startPage(searchVo.getCurrentPage(),searchVo.getSize());
        Page<TcWdiFile> page = iWdiService.searchWdiListPageHelper(searchVo);
        return BaseResult.success(page,page.getTotal());
    }

    @PostMapping("/searchWdjList")
    public BaseResult searchWdjList(@RequestBody SearchVo searchVo){
        return BaseResult.success(iWdiService.searchWdjList(searchVo));
    }

    @PostMapping("/repairWdj")
    public BaseResult repairWdj(@RequestBody TcWdjFile tcWdjFile){
        iWdiService.repairWdj(tcWdjFile);
        return BaseResult.success("出库数量修复完成");
    }

}
