package com.eTag.back.api.service.impl;

import cn.hutool.crypto.digest.DigestUtil;
import cn.hutool.jwt.JWT;
import com.eTag.back.api.mapper.UserMapper;
import com.eTag.back.api.pojo.JwtUser;
import com.eTag.back.api.pojo.User;
import com.eTag.back.api.service.IUserService;
import com.eTag.back.utils.DateUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

@Service
public class UserServiceImpl implements UserDetailsService {

    @Resource
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userMapper.selectByUsername(username);
        if(user == null) throw new UsernameNotFoundException("用户名或者密码错误");
        return new JwtUser(user);
    }
}
