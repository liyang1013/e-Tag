package com.keboda.eomsback.authorityReview.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.github.pagehelper.Page;
import com.keboda.eomsback.authorityReview.mapper.PersonalPositionMapper;
import com.keboda.eomsback.authorityReview.pojo.PersonalPosition;
import com.keboda.eomsback.authorityReview.service.IPersonalPositionService;
import com.keboda.eomsback.entity.SearchVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@DS("myself")
public class PersonalPositionServiceImpl implements IPersonalPositionService {

    @Resource
    private PersonalPositionMapper personalPositionMapper;

    @Override
    public Page<PersonalPosition> searchPersonalPositionRecordsListPageHelper(SearchVo searchVo) {
        return personalPositionMapper.searchPersonalPositionRecordsListPageHelper(searchVo);
    }

    @Override
    public void deletePersonalPositionRecords(PersonalPosition personalPosition) {
        personalPositionMapper.deleteByPrimaryKey(personalPosition);
    }

    @Override
    public PersonalPosition PersonalPositionContrastRecords(Integer year, int itype, String code) {
        return personalPositionMapper.PersonalPositionContrastRecords(year,itype,code);
    }

    @Override
    public void merge(int year, int itype, String code, String name, String permissionCode, String permissionName) {
        PersonalPosition personalPosition = personalPositionMapper.selectByPrimaryKey(year, itype, code, permissionCode);
        if(personalPosition == null){
            personalPosition = new PersonalPosition();
            personalPosition.setYear(year);
            personalPosition.setCode(code);
            personalPosition.setItype(itype);
            personalPosition.setName(name);
            personalPosition.setPermissionCode(permissionCode);
            personalPosition.setPermissionName(permissionName);
            personalPositionMapper.insertSelective(personalPosition);
        }else{

            personalPosition.setName(name);
            personalPosition.setPermissionName(permissionName);
            personalPositionMapper.updateByPrimaryKey(personalPosition);
        }
    }
}
