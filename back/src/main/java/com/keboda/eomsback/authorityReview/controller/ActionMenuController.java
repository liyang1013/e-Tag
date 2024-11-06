package com.keboda.eomsback.authorityReview.controller;

import com.keboda.eomsback.authorityReview.pojo.ActionMenu;
import com.keboda.eomsback.authorityReview.service.IActionMenuService;
import com.keboda.eomsback.entity.BaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/action")
public class ActionMenuController {

    @Autowired
    private IActionMenuService iActionMenuService;

    @RequestMapping("/initAction")
    public BaseResult initAction(){
        return BaseResult.success(iActionMenuService.initAction());
    }

    @RequestMapping("/saveAction")
    public BaseResult saveAction(@RequestBody ActionMenu actionMenu){
        iActionMenuService.saveAction(actionMenu);
        return BaseResult.success("修改"+actionMenu.getName()+"action成功");
    }
}
