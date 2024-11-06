package com.keboda.eomsback.stock.mapper;

import com.keboda.eomsback.entity.SearchVo;
import com.keboda.eomsback.stock.pojo.ImdFile;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ImdFileMapper {

    List<ImdFile> searchImdList(SearchVo searchVo);

    ImdFile selectByKey(@Param("centre") String centre, @Param("imd01") String imd01);
}