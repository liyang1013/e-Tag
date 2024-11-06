package com.keboda.eomsback.purchase.mapper;

import com.keboda.eomsback.entity.SearchVo;
import com.keboda.eomsback.purchase.pojo.RvuFile;
import com.keboda.eomsback.purchase.pojo.RvvFile;
import com.keboda.eomsback.purchase.pojo.RvvFileKey;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

public interface RvvFileMapper {

    List<RvvFile> searchListByOrderCode(SearchVo searchVo);

    int updateByPrimaryKeySelective(RvvFile rvvFile);
}