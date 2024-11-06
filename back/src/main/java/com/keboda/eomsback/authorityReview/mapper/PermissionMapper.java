package com.keboda.eomsback.authorityReview.mapper;

import com.keboda.eomsback.authorityReview.pojo.AuthorityRecordsVo;
import com.keboda.eomsback.authorityReview.pojo.Permission;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface PermissionMapper {

    Permission selectByPrimaryKey(Permission permission);

    void insertSelective(Permission permission);

    void deletePositionRecords(AuthorityRecordsVo vo);

    List<AuthorityRecordsVo> searchRecordsList(@Param("year") Integer year, @Param("code") String code,@Param("exclude") String[] exclude);

    void updateSelective(Permission permission);
}