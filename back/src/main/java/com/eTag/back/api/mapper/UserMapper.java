package com.eTag.back.api.mapper;

import com.eTag.back.api.pojo.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    int insert(User record);

    int insertSelective(User record);
}