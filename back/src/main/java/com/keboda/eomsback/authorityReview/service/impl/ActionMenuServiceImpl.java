package com.keboda.eomsback.authorityReview.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.keboda.eomsback.authorityReview.mapper.ActionMenuMapper;
import com.keboda.eomsback.authorityReview.pojo.ActionMenu;
import com.keboda.eomsback.authorityReview.service.IActionMenuService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@DS("myself")
public class ActionMenuServiceImpl implements IActionMenuService {

    @Resource
    private ActionMenuMapper actionMenuMapper;

    @Override
    public List<ActionMenu> initAction() {
        List<ActionMenu> list =  actionMenuMapper.initAction();
        list.forEach( action -> {
            action.setTags(action.getAction().split(","));
        });
        return list;
    }

    @Override
    @Transactional
    public void saveAction(ActionMenu actionMenu) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < actionMenu.getTags().length; i++) {
            String[] tags = actionMenu.getTags();
            sb.append(tags[i]);
            if(i != tags.length - 1){
               sb.append(",");
            }
        }
        actionMenu.setAction(sb.toString());
        actionMenuMapper.updateByPrimaryKey(actionMenu);
    }

    @Override
    public ActionMenu selectByPrimaryKey(String code) {
        return actionMenuMapper.selectByPrimaryKey(code);
    }
}
