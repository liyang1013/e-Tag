package com.keboda.eomsback.sale.mapper;

import com.keboda.eomsback.sale.pojo.OeaFile;
import org.apache.ibatis.annotations.Param;

public interface OeaFileMapper {

    int insertSelective(OeaFile record);

    int updateByPrimaryKeySelective(OeaFile record);

    void InvalidDocumentDelete(@Param("centre")String centre);
}