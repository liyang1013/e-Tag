package com.eTag.back.api.controller;

import com.eTag.back.api.service.IViewService;
import com.eTag.back.entity.BaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/view")
public class ViewController {

    @Autowired
    private IViewService iViewService;

    @GetMapping("/getView")
    public BaseResult getViewByUser(){
        return BaseResult.success(iViewService.getViewByUser());
    };
}
