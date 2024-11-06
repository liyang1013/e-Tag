package com.keboda.eomsback.jira.controller;

import com.keboda.eomsback.entity.BaseResult;
import com.keboda.eomsback.entity.SearchVo;
import com.keboda.eomsback.jira.pojo.User;
import com.keboda.eomsback.jira.service.IJiraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jira")
public class JiraController {

    @Autowired
    private IJiraService iJiraService;

    @PostMapping("/updatePassword")
    public BaseResult updatePassword(@RequestBody User user){
        return BaseResult.success(iJiraService.updatePassword(user));
    }

}
