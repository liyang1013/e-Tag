package com.keboda.eomsback.produce.mapper;

import com.github.pagehelper.Page;
import com.keboda.eomsback.entity.SearchVo;
import com.keboda.eomsback.produce.pojo.SfuFile;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface SfuFileMapper {

    List<SfuFile> searchSfuList(SearchVo searchVo);

    void updateDate(@Param("sfu") SfuFile sfu, @Param("centre") String centre, @Param("ddate") Date ddate,@Param("flag")Boolean flag);

    Page<SfuFile> searchSfuListPageHelper(SearchVo searchVo);

    int insertSelective(SfuFile record);

    int updateByPrimaryKeySelective(SfuFile record);
}
