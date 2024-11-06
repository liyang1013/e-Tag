package com.keboda.eomsback.produce.mapper;

import com.github.pagehelper.Page;
import com.keboda.eomsback.entity.SearchVo;
import com.keboda.eomsback.produce.pojo.SfbFile;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface SfbFileMapper {
    List<SfbFile> searchSfbList(SearchVo searchVo);

    SfbFile searchSfb(SearchVo searchVo);

    Page<SfbFile> searchSfbListPageHelper(SearchVo searchVo);

    void updateDate(@Param("sfb") SfbFile sfb, @Param("centre") String centre, @Param("ddate") Date ddate,@Param("flag") Boolean flag);

    int updateByPrimaryKeySelective(SfbFile sfbFile);
}
