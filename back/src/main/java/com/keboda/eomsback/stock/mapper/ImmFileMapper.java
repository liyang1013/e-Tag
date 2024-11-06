package com.keboda.eomsback.stock.mapper;

import com.keboda.eomsback.stock.pojo.ImmFile;
import org.apache.ibatis.annotations.Param;

public interface ImmFileMapper {

    int insertSelective(ImmFile record);

    int updateByPrimaryKeySelective(ImmFile record);

    void InvalidDocumentDelete(@Param("centre") String centre);
}