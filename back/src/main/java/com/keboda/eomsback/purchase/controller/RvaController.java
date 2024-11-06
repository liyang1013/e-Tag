package com.keboda.eomsback.purchase.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.keboda.eomsback.entity.SearchVo;
import com.keboda.eomsback.purchase.pojo.RvaFile;
import com.keboda.eomsback.purchase.pojo.RvbFile;
import com.keboda.eomsback.purchase.pojo.RvuFile;
import com.keboda.eomsback.purchase.service.IRvaService;
import com.keboda.eomsback.entity.BaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/rva")
@RestController
public class RvaController {

    @Autowired
    private IRvaService iRvaService;

    @RequestMapping("/searchListPageHelper")
    public BaseResult searchListPageHelper(@RequestBody SearchVo searchVo){
        PageHelper.startPage(searchVo.getCurrentPage(),searchVo.getSize());
        Page<RvaFile> page = iRvaService.searchListPageHelper(searchVo);
        return BaseResult.success(page,page.getTotal());
    }

    @RequestMapping("/updateConf")
    public BaseResult updateConf(@RequestBody RvaFile rvaFile){
        iRvaService.updateConf(rvaFile);
        return BaseResult.success("修改成功");
    }

    @PostMapping("/updateDate")
    public BaseResult updateDate(@RequestBody RvaFile rvaFile){
        iRvaService.updateDate(rvaFile);
        return BaseResult.success("收货日期修改成功");
    }
}
