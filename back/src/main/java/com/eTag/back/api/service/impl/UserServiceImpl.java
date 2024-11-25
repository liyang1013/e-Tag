package com.eTag.back.api.service.impl;

import cn.hutool.crypto.digest.DigestUtil;
import cn.hutool.jwt.JWT;
import com.eTag.back.api.mapper.UserMapper;
import com.eTag.back.api.pojo.User;
import com.eTag.back.api.service.IUserService;
import com.eTag.back.utils.DateUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

@Service
public class UserServiceImpl implements IUserService {


    @Resource
    private UserMapper userMapper;

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private long expiration;

    @Override
    public String login(User user)  {
        User u = userMapper.selectByUsername(user.getUsername(), DigestUtil.md5Hex(user.getPasswd()));
        if (u == null) throw new RuntimeException("用户或者密码错误");

        String token = JWT.create()
                .setIssuedAt(new Date())
                .setExpiresAt(new Date(System.currentTimeMillis() + 60L))// DateUtils.DAY_MILLISECONDS))
                .setPayload("name", u.getUsername())
                .setKey(secret.getBytes())
                .sign();

        return token;

    }
}
