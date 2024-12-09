package com.eTag.back.api.controller;

import com.eTag.back.api.pojo.User;
import com.eTag.back.api.service.impl.UserServiceImpl;
import com.eTag.back.entity.BaseResult;
import com.eTag.back.entity.SearchVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

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

    @PostMapping("/addUser")
    @PreAuthorize("hasAuthority('admin')")
    public BaseResult addUser(@RequestBody  User user){
        userService.addUser(user);
        return BaseResult.success();
    }

    @GetMapping("/deleteUser")
    @PreAuthorize("hasAuthority('admin')")
    public BaseResult deleteUser(Integer uid){
        userService.deleteUser(uid);
        return BaseResult.success();
    }

    @GetMapping("/getSystemInfo")
    public BaseResult getSystemInfo(){
        return BaseResult.success(userService.getSystemInfo());
    }

    @PostMapping("/changePwd")
    public BaseResult changePwd(@RequestBody HashMap<String,String> map){
        userService.changePwd(map);
        return BaseResult.success();
    }

}
