package com.keboda.eomsback.stock.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.keboda.eomsback.entity.BaseResult;
import com.keboda.eomsback.entity.SearchVo;
import com.keboda.eomsback.stock.pojo.ImgFile;
import com.keboda.eomsback.stock.service.IImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/img")
public class ImgController {

    @Autowired
    private IImgService iImgService;

    @RequestMapping("/searchImgListPageHelper")
    public BaseResult searchImgListPageHelper(@RequestBody SearchVo searchVo){
        PageHelper.startPage(searchVo.getCurrentPage(),searchVo.getSize());
        Page<ImgFile> page = iImgService.searchImgListPageHelper(searchVo);
        return BaseResult.success(page,page.getTotal());
    }

    @RequestMapping("/repairImg")
    public BaseResult repairImg(@RequestBody SearchVo searchVo){
        iImgService.repairImg(searchVo);
        return BaseResult.success("修复现存量成功");
    }
}
