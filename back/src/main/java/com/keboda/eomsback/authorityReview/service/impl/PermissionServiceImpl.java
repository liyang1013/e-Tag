package com.keboda.eomsback.authorityReview.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.keboda.eomsback.authorityReview.mapper.ActionMenuMapper;
import com.keboda.eomsback.authorityReview.mapper.PermissionMapper;
import com.keboda.eomsback.authorityReview.pojo.AuthorityRecordsVo;
import com.keboda.eomsback.authorityReview.pojo.Permission;
import com.keboda.eomsback.authorityReview.service.IPermissionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@DS("myself")
public class PermissionServiceImpl implements IPermissionService {

    @Resource
    private PermissionMapper permissionMapper;
    @Resource
    private ActionMenuMapper actionMenuMapper;

    @Override
    public Permission selectByPrimaryKey(Permission permission) {
        return permissionMapper.selectByPrimaryKey(permission);
    }

    @Override
    public void insertSelective(Permission permission) {
        permissionMapper.insertSelective(permission);
    }

    @Override
    @Transactional
    public void deletePositionRecords(List<AuthorityRecordsVo> authorityRecordsVoList) {
        for (AuthorityRecordsVo vo : authorityRecordsVoList) {
            permissionMapper.deletePositionRecords(vo);
        }
    }

    @Override
    public List<AuthorityRecordsVo> searchRecordsList(Integer year,String code) {
        String[] exclude = actionMenuMapper.selectByPrimaryKey("exclude").getAction().split(",");
        return permissionMapper.searchRecordsList(year,code,exclude);
    }

    @Override
    public void merge(Permission permission) {
        Permission isExit = permissionMapper.selectByPrimaryKey(permission);
        if (isExit == null) permissionMapper.insertSelective(permission);
        else permissionMapper.updateSelective(permission);
    }
}
