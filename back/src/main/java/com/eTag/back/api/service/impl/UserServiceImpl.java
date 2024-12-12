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
import java.util.HashMap;

@Service
public class UserServiceImpl implements UserDetailsService {

    @Resource
    private UserMapper userMapper;

    @Resource
    DevicesMapper devicesMapper;

    @Value("${file.getApi}")
    private String getApi;

    @Value("${file.postApi}")
    private String postApi;


    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userMapper.selectByUsername(username);
        if(user == null) throw new UsernameNotFoundException("用户名不存在");
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

        User u = userMapper.selectUsernameWithoutUser(user);
        if(u != null) throw new RuntimeException("用户名已存在不可重复");

        u = userMapper.selectAppidWithoutUser(user);
        if(u != null) throw new RuntimeException("appid已存在不可重复");

        if (user.getUid() == null) {
            user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
            userMapper.insertSelective(user);
        } else {
            user.setPassword(null);
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
        user.setPassword(getApi);
        user.setNewPassword(postApi);
        return user;
    }

    public void changePwd(HashMap<String, String> map) {
        User u = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (!new BCryptPasswordEncoder().matches(map.get("oldPassword"), u.getPassword())) throw new RuntimeException("旧密码错误");
        if(! map.get("newPassword").equals(map.get("confirmPassword"))) throw new RuntimeException("两次输入的新密码不一致");
        userMapper.changePwd(u.getUid(),new BCryptPasswordEncoder().encode(map.get("newPassword")) );
    }
}
