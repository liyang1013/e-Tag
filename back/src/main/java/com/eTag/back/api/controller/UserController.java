package com.eTag.back.api.controller;

import com.eTag.back.api.pojo.Devices;
import com.eTag.back.api.pojo.User;
import com.eTag.back.api.service.impl.UserServiceImpl;
import com.eTag.back.entity.BaseResult;
import com.eTag.back.entity.SearchVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @PostMapping("/searchUser")
    @PreAuthorize("hasAuthority('admin')")
    public BaseResult searchUserPageHelper(@RequestBody SearchVo searchVo){
        PageHelper.startPage(searchVo.getCurrentPage(), searchVo.getSize());
        Page<User> page = userService.searchUserPageHelper(searchVo);
        return BaseResult.success(page);
    }
}
