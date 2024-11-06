package com.keboda.eomsback.purchase.mapper;

import com.keboda.eomsback.entity.SearchVo;
import com.keboda.eomsback.purchase.pojo.PmnFile;
import com.keboda.eomsback.purchase.pojo.PmnFileKey;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

public interface PmnFileMapper {

    int insertSelective(PmnFile record);

    int updateByPrimaryKeySelective(PmnFile record);

    List<PmnFile> searchListByOrderCode(SearchVo searchVo);
}