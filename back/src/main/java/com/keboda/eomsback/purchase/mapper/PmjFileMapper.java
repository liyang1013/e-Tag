package com.keboda.eomsback.purchase.mapper;

import com.keboda.eomsback.entity.SearchVo;
import com.keboda.eomsback.purchase.pojo.PmjFile;
import com.keboda.eomsback.purchase.pojo.PmjFileKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PmjFileMapper {

    int insertSelective(PmjFile record);

    int updateByPrimaryKeySelective(PmjFile record);

    List<PmjFile> searchListByOrderCode(SearchVo searchVo);

    void deleteByPrimaryKey(@Param("code") String code, @Param("centre") String centre);
}