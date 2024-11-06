package com.keboda.eomsback.authorityReview.service;

import com.github.pagehelper.Page;
import com.keboda.eomsback.authorityReview.pojo.PersonalPosition;
import com.keboda.eomsback.entity.SearchVo;

public interface IPersonalPositionService {
    Page<PersonalPosition> searchPersonalPositionRecordsListPageHelper(SearchVo searchVo);

    void deletePersonalPositionRecords(PersonalPosition personalPosition);

    PersonalPosition PersonalPositionContrastRecords(Integer year, int itype, String code);

    void merge(int year, int itype, String code, String name,String permissionCode,String permissionName);
}
