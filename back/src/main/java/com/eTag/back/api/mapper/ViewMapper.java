package com.eTag.back.api.mapper;

import com.eTag.back.api.pojo.View;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ViewMapper {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(View record);

    int updateByPrimaryKeySelective(View record);

    List<View> getViewByUserid(Integer uid);
}