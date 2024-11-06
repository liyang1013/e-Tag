package com.keboda.eomsback.purchase.mapper;

import com.github.pagehelper.Page;
import com.keboda.eomsback.entity.SearchVo;
import com.keboda.eomsback.purchase.pojo.RvaFile;
import org.apache.ibatis.annotations.Param;

public interface RvaFileMapper {
    Page<RvaFile> searchListPageHelper( SearchVo searchVo);

    RvaFile selectByPrimaryKey(@Param("rva01") String rva01, @Param("centre") String centre);

    int updateByPrimaryKeySelective(RvaFile record);
}