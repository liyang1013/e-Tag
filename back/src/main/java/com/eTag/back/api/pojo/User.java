package com.eTag.back.api.pojo;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
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
     * 用户许可
     */
    private String appid;

    /**
     * 状态
     */
    private Boolean status;


    private String appSecret;


    private Date licenseTime;

    private String role;

    private static final long serialVersionUID = 1L;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
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
        return true;
    }
}