package com.keboda.eomsback.purchase.mapper;

import com.github.pagehelper.Page;
import com.keboda.eomsback.entity.SearchVo;
import com.keboda.eomsback.purchase.pojo.PmiFile;
import org.apache.ibatis.annotations.Param;

public interface PmiFileMapper {

    int insertSelective(PmiFile record);

    int updateByPrimaryKeySelective(PmiFile record);

    Page<PmiFile> searchListPageHelper(SearchVo searchVo);

    void deleteByPrimaryKey(@Param("code") String code, @Param("centre") String centre);
}