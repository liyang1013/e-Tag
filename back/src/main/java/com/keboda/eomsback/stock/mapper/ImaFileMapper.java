package com.keboda.eomsback.stock.mapper;

import com.github.pagehelper.Page;
import com.keboda.eomsback.stock.pojo.ImaFile;
import com.keboda.eomsback.entity.SearchVo;
import com.keboda.eomsback.stock.pojo.ImgFile;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;


public interface ImaFileMapper {

    Page<ImaFile> searchListPageHelper(SearchVo searchVo);

    ImaFile selectByPrimaryKey(@Param("centre") String centre, @Param("ima01") String ima01);

    int updateByPrimaryKeySelective(ImaFile record);

}
