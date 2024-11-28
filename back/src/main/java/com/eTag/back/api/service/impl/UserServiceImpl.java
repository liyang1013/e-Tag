package com.eTag.back.api.service.impl;

import com.eTag.back.api.mapper.UserMapper;
import com.eTag.back.api.pojo.User;
import com.eTag.back.entity.SearchVo;
import com.github.pagehelper.Page;
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
        return userMapper.selectByUsername(username);
    }

    public Page<User> searchUserPageHelper(SearchVo searchVo) {
        return userMapper.searchUserPageHelper(searchVo);
    }


    public void writeLoginInfo(User user) {
        userMapper.writeLoginInfo(user);
    }
}
