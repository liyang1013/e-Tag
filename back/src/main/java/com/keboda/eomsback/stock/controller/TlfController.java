package com.keboda.eomsback.stock.controller;

import cn.hutool.core.io.IoUtil;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.keboda.eomsback.entity.BaseResult;
import com.keboda.eomsback.entity.SearchVo;
import com.keboda.eomsback.stock.pojo.EWStockGap;
import com.keboda.eomsback.stock.service.ITlfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

@RestController
@RequestMapping("/tlf")
public class TlfController {

    @Autowired
    private ITlfService iTlfService;

    @RequestMapping("/searchEWStockGapPageHelper")
    public BaseResult searchEWStockGapPageHelper(@RequestBody SearchVo searchVo) {
        PageHelper.startPage(searchVo.getCurrentPage(),searchVo.getSize());
        Page<EWStockGap> page = iTlfService.searchEWStockGapPageHelper(searchVo);
        return BaseResult.success(page,page.getTotal());
    }
}
