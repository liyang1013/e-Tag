package com.eTag.back.api.controller;

import cn.hutool.jwt.JWTUtil;
import com.eTag.back.api.pojo.User;
import com.eTag.back.api.service.impl.UserServiceImpl;
import com.eTag.back.entity.BaseResult;
import com.eTag.back.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserServiceImpl userDetailsService;

    @PostMapping("/login")
    public BaseResult createAuthenticationToken(@RequestBody User user) {

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
        User userDetails = userDetailsService.loadUserByUsername(user.getUsername());
        String token = JwtUtil.generateToken(userDetails.getUsername());
        Object exp = JWTUtil.parseToken(token).getPayload("exp");

        userDetailsService.writeLoginInfo(user);

        return BaseResult.success(exp, token);
    }
}