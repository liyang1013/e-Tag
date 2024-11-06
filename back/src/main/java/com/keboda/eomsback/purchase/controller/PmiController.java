package com.keboda.eomsback.purchase.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.keboda.eomsback.entity.BaseResult;
import com.keboda.eomsback.entity.SearchVo;
import com.keboda.eomsback.purchase.pojo.PmiFile;
import com.keboda.eomsback.purchase.service.IPmiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pmi")
public class PmiController {

    @Autowired
    private IPmiService iPmiService;

    @PostMapping("/searchListPageHelper")
    public BaseResult searchListPageHelper(@RequestBody SearchVo searchVo){
        PageHelper.startPage(searchVo.getCurrentPage(),searchVo.getSize());
        Page<PmiFile> page = iPmiService.searchListPageHelper(searchVo);
        return BaseResult.success(page,page.getTotal());
    }

    @PostMapping("/deleteDocument")
    public BaseResult deleteDocument(@RequestBody List<PmiFile> pmiFileList){
        return BaseResult.success(iPmiService.deleteDocument(pmiFileList));
    }


}
