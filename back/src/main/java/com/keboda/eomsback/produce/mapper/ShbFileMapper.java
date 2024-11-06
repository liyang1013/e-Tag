package com.keboda.eomsback.produce.mapper;

import com.keboda.eomsback.entity.SearchVo;
import com.keboda.eomsback.produce.pojo.ShbFile;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface ShbFileMapper {

    List<ShbFile> searchShbList(SearchVo searchVo);

    void updateDate(@Param("shb") ShbFile shb, @Param("centre") String centre, @Param("ddate") Date ddate,@Param("flag") Boolean flag);
}
