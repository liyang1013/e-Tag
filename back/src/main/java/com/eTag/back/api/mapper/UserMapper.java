package com.eTag.back.api.mapper;

import com.eTag.back.api.pojo.User;
import com.eTag.back.entity.SearchVo;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

    int insertSelective(User record);

    void updateSelective(User user);

    User selectByUsername(@Param("username") String username);

    Page<User> searchUserPageHelper(SearchVo searchVo);

    void writeLoginInfo(User user);

    void deleteByUid(Integer uid);

    String selectAppSecretByAppid(String clientid);
}