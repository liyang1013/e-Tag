package com.eTag.back.api.mapper;

import com.eTag.back.api.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

    int insertSelective(User record);

    User selectByUsername(@Param("username") String username, @Param("passwd") String passwd);
}