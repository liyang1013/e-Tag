package com.keboda.eomsback.stock.mapper;

import com.github.pagehelper.Page;
import com.keboda.eomsback.entity.SearchVo;
import com.keboda.eomsback.stock.pojo.InaFile;
import org.apache.ibatis.annotations.Param;

public interface InaFileMapper {
    int insertSelective(InaFile record);

    int updateByPrimaryKeySelective(InaFile record);

    Page<InaFile> searchListPageHelper(SearchVo searchVo);

    void alterGem(InaFile inaFile);

    void alterPja(InaFile inaFile);

    void InvalidDocumentDelete(@Param("centre")String centre);

    void alterConf(InaFile inaFile);
}