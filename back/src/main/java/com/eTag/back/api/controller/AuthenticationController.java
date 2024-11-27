package com.eTag.back.api.controller;

import com.eTag.back.api.pojo.User;
import com.eTag.back.api.service.impl.UserServiceImpl;
import com.eTag.back.entity.BaseResult;
import com.eTag.back.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserServiceImpl userDetailsService;

    @PostMapping("/login")
    public BaseResult createAuthenticationToken(@RequestBody User user) throws Exception {
        try {
           authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword())
            );
        } catch (AuthenticationException e) {
            throw new Exception("Incorrect username or password", e);
        }

        final User userDetails = userDetailsService.loadUserByUsername(user.getUsername());
        final String token = JwtUtil.generateToken(userDetails.getUsername());

        return BaseResult.success(token);
    }
}