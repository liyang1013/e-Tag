package com.keboda.eomsback.stock.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.keboda.eomsback.stock.pojo.ImaFile;
import com.keboda.eomsback.entity.SearchVo;
import com.keboda.eomsback.stock.service.IImaService;
import com.keboda.eomsback.entity.BaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RequestMapping("/ima")
@RestController
public class ImaController {

    @Autowired
    private IImaService iImaService;

    @RequestMapping("/searchListPageHelper")
    public BaseResult searchListPageHelper(@RequestBody SearchVo searchVo){
        PageHelper.startPage(searchVo.getCurrentPage(),searchVo.getSize());
        Page<ImaFile> page = iImaService.searchListPageHelper(searchVo);
        return BaseResult.success(page,page.getTotal());
    }

    @RequestMapping("/updateByExcel")
    public BaseResult updateByExcel( MultipartFile file, String centre) throws IOException {
        int count = iImaService.updateByExcel(file,centre);
        return BaseResult.success("物料信息更新超成功: " + count);
    }

    @PostMapping("/updateUnit")
    public BaseResult updateUnit(@RequestBody ImaFile imaFile){
        iImaService.updateUnit(imaFile);
        return BaseResult.success("修改单位成功");
    }

}
