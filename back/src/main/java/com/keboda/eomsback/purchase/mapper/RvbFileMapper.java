package com.keboda.eomsback.purchase.mapper;

import com.keboda.eomsback.entity.SearchVo;
import com.keboda.eomsback.purchase.pojo.RvbFile;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

public interface RvbFileMapper {

    List<RvbFile> searchListByOrderCode(SearchVo searchVo);

    RvbFile selectByPrimaryKey(RvbFile rvbFile);

    int updateByPrimaryKeySelective(RvbFile record);
}