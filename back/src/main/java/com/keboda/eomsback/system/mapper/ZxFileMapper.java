package com.keboda.eomsback.system.mapper;

import com.github.pagehelper.Page;
import com.keboda.eomsback.authorityReview.pojo.PersonalPosition;
import com.keboda.eomsback.entity.SearchVo;
import com.keboda.eomsback.system.pojo.ZxFile;

import java.util.List;

public interface ZxFileMapper {

    Page<ZxFile> searchListPageHelper(SearchVo searchVo);

    ZxFile selectByPrimaryKey(String zx01);

    Page<PersonalPosition> searchPersonalPositionContrastRecordsListPageHelper(SearchVo searchVo);

    List<PersonalPosition> personalPositionContrastRecords(Integer itype);
}