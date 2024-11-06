package com.keboda.eomsback.stock.mapper;

import com.github.pagehelper.Page;
import com.keboda.eomsback.entity.SearchVo;
import com.keboda.eomsback.stock.pojo.ImgFile;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

public interface ImgFileMapper {

    void updateQty(@Param("centre") String centre, @Param("img01") String img01, @Param("img02") String img02, @Param("img03") String img03, @Param("img04") String img04, @Param("img10") BigDecimal img10);

    Page<ImgFile> searchImgListPageHelper(SearchVo searchVo);

    ImgFile selectByKey(@Param("centre") String centre, @Param("img02") String img02, @Param("img01") String img01);

    void insertSelective(ImgFile imgFile);
}
