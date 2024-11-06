package com.keboda.eomsback.email.controller;

import com.keboda.eomsback.email.pojo.EmailBody;
import com.keboda.eomsback.email.service.EmailService;
import com.keboda.eomsback.entity.BaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @RequestMapping("/hikvisionSend")
    public BaseResult hikvisionSend(@RequestBody EmailBody emailBody){
        return BaseResult.success(emailService.hikvisionSend(emailBody));
    }

    @RequestMapping("/teamsSend")
    public BaseResult teamsSend(@RequestBody EmailBody emailBody){
        return BaseResult.success(emailService.teamsSend(emailBody));
    }

    @RequestMapping("/itSupportSend")
    public BaseResult itSupportSend(@RequestBody EmailBody emailBody){
        return BaseResult.success(emailService.itSupportSend(emailBody));
    }

}
