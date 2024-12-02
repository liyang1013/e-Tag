package com.eTag.back.api.service.impl;

import com.eTag.back.api.mapper.DevicesMapper;
import com.eTag.back.api.mapper.UserMapper;
import com.eTag.back.api.pojo.User;
import com.eTag.back.entity.SearchVo;
import com.eTag.back.utils.DateUtils;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Calendar;

@Service
public class UserServiceImpl implements UserDetailsService {

    @Resource
    private UserMapper userMapper;

    @Resource
    DevicesMapper devicesMapper;

    @Value("${file.api}")
    private String api;


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

    public void addUser(User user) {

        user.setLicenseTime(DateUtils.add(user.getLicenseTime(), Calendar.HOUR,8));

        if (user.getUid() == null) {

            User isExist = userMapper.selectByUsername(user.getUsername());
            if(isExist != null) throw new RuntimeException("用户名已存在不能重复");

            user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
            userMapper.insertSelective(user);
        } else {
            if (!"******".equals(user.getPassword())) {
                user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
            } else {
                user.setPassword(null);
            }
            userMapper.updateSelective(user);
        }
    }

    @Transactional
    public void deleteUser(Integer uid) {
        devicesMapper.deleteByUid(uid);
        userMapper.deleteByUid(uid);
    }

    public User getSystemInfo() {
        User u = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userMapper.selectByUsername(u.getUsername());
        user.setPassword(api);
        return user;
    }
}
