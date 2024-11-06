package com.keboda.eomsback.assets.controller;

import com.keboda.eomsback.assets.service.IFajService;
import com.keboda.eomsback.entity.BaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/faj")
public class FajController {

    @Autowired
    private IFajService iFajService;

    @RequestMapping("/updateByExcel")
    public BaseResult updateByExcel(MultipartFile file, String centre) throws IOException {
        int count = iFajService.updateByExcel(file,centre);
        return BaseResult.success("固定资产批量修改成功: "+ count);
    }
}
