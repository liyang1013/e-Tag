package com.keboda.eomsback.authorityReview.mapper;

import com.keboda.eomsback.authorityReview.pojo.ActionMenu;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface ActionMenuMapper {
    int deleteByPrimaryKey(String code);

    int updateByPrimaryKey(ActionMenu record);

    List<ActionMenu> initAction();

    ActionMenu selectByPrimaryKey(String code);
}