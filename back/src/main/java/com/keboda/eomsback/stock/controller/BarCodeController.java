package com.keboda.eomsback.stock.controller;

import com.keboda.eomsback.stock.service.IBarCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/barcode")
public class BarCodeController {

    @Autowired
    private IBarCodeService iBarCodeService;
}
