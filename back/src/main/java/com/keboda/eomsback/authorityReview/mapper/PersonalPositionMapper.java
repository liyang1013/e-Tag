package com.keboda.eomsback.authorityReview.mapper;

import com.github.pagehelper.Page;
import com.keboda.eomsback.authorityReview.pojo.PersonalPosition;
import com.keboda.eomsback.entity.SearchVo;
import org.apache.ibatis.annotations.Param;

public interface PersonalPositionMapper {

    int insertSelective(PersonalPosition record);

    Page<PersonalPosition> searchPersonalPositionRecordsListPageHelper(SearchVo searchVo);

    PersonalPosition selectByPrimaryKey(@Param("year") int year,@Param("itype") int itype, @Param("code") String zx01, @Param("permissionCode") String zw01);

    void deleteByPrimaryKey(PersonalPosition personalPosition);

    PersonalPosition PersonalPositionContrastRecords(@Param("year") Integer year, @Param("itype") int itype, @Param("code") String code);

    void updateByPrimaryKey(PersonalPosition personalPosition);
}