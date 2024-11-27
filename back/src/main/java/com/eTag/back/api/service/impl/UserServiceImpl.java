package com.eTag.back.api.service.impl;

import com.eTag.back.api.mapper.UserMapper;
import com.eTag.back.api.pojo.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserDetailsService {

    @Resource
    private UserMapper userMapper;


    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userMapper.selectByUsername(username);
        if(user == null) throw new UsernameNotFoundException("用户名密码错误");
        return user;
    }
}
