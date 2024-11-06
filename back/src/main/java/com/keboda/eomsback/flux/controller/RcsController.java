package com.keboda.eomsback.flux.controller;

import com.keboda.eomsback.flux.service.IRcsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rcs")
public class RcsController {

    @Autowired
    private IRcsService iRcsService;
}
