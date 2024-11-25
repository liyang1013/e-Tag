package com.eTag.back.api.controller;

import com.eTag.back.api.pojo.User;
import com.eTag.back.api.service.impl.UserServiceImpl;
import com.eTag.back.entity.BaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private UserServiceImpl userService;

    @PostMapping("/login")
    public BaseResult createAuthenticationToken(@RequestBody User user) {

        String token = userService.login(user);
        return BaseResult.success(token);
    }

}