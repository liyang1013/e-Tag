package com.eTag.back.api.pojo;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.*;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * user
 */
@Data
public class User implements UserDetails {
    private Integer uid;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    private Collection<? extends GrantedAuthority> authorities;

    /**
     * 上次登入时间
     */
    private Date lastLoginTime;

    /**
     * 登入地址
     */
    private Integer ipAddress;

    /**
     * 设备许可
     */
    private String appid;

    private String appSecret;

    /**
     * 状态
     */
    private Boolean status;

    private String city;


    /**
     * 到期时间
     */
    private Date licenseTime;

    /**
     * 角色
     */
    private String role;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        return new ArrayList<>(Collections.singleton(new SimpleGrantedAuthority(this.role)));
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return new Date().before(this.licenseTime);
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.status;
    }
}