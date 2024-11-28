package com.eTag.back.api.service.impl;

import com.eTag.back.api.mapper.ViewMapper;
import com.eTag.back.api.pojo.User;
import com.eTag.back.api.pojo.View;
import com.eTag.back.api.service.IViewService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ViewServiceImpl implements IViewService {

    @Resource
    private ViewMapper viewMapper;


    @Override
    public List<View> getViewByUser() {
        User u = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return viewMapper.getViewByUserid(u.getUid());
    }
}
