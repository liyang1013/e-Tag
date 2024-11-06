package com.keboda.eomsback.system.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.github.pagehelper.Page;
import com.keboda.eomsback.entity.SearchVo;
import com.keboda.eomsback.system.pojo.GazFile;
import com.keboda.eomsback.system.pojo.GazFileKey;
import org.apache.ibatis.annotations.Param;

public interface GazFileMapper {
    int updateByPrimaryKeySelective(GazFile record);

    GazFile selectByPrimaryKey(@Param("gaz01") String gaz01);

    Page<GazFile> searchGazListPageHelper(SearchVo searchVo);
}