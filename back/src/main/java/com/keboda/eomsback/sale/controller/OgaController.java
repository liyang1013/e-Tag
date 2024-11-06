package com.keboda.eomsback.sale.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.keboda.eomsback.entity.BaseResult;
import com.keboda.eomsback.entity.SearchVo;
import com.keboda.eomsback.purchase.pojo.RvbFile;
import com.keboda.eomsback.purchase.pojo.RvuFile;
import com.keboda.eomsback.sale.pojo.OgaFile;
import com.keboda.eomsback.sale.pojo.OgbFile;
import com.keboda.eomsback.sale.pojo.TcWdiFile;
import com.keboda.eomsback.sale.service.IOgaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/oga")
public class OgaController {

    @Autowired
    private IOgaService iOgaService;


    @RequestMapping("/searchOgaListPageHelper")
    public BaseResult searchOgaListPageHelper(@RequestBody SearchVo searchVo){
        PageHelper.startPage(searchVo.getCurrentPage(),searchVo.getSize());
        Page<OgaFile> page = iOgaService.searchOgaListPageHelper(searchVo);
        return BaseResult.success(page,page.getTotal());
    }

    @RequestMapping("/searchOgbList")
    public BaseResult searchOgbList(@RequestBody SearchVo searchVo){
        List<OgbFile> list = iOgaService.searchOgbList(searchVo);
        return BaseResult.success(list);
    }

    @PostMapping("/alterOgaDate")
    public BaseResult alterOgaDate(@RequestBody OgaFile ogaFile){
        iOgaService.alterOgaDate(ogaFile);
        return BaseResult.success("出货日期修改成功");
    }
}
