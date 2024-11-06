package com.keboda.eomsback.authorityReview.service;

import com.keboda.eomsback.authorityReview.pojo.ActionMenu;

import java.util.List;

public interface IActionMenuService {
    List<ActionMenu> initAction();

    void saveAction(ActionMenu actionMenu);

    ActionMenu selectByPrimaryKey(String code);
}
