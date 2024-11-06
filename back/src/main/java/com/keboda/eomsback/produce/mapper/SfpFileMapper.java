package com.keboda.eomsback.produce.mapper;

import com.github.pagehelper.Page;
import com.keboda.eomsback.entity.SearchVo;
import com.keboda.eomsback.produce.pojo.SfpFile;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface SfpFileMapper {
    List<SfpFile> searchSfpList(SearchVo searchVo);

    void updateDate(@Param("sfp") SfpFile sfp, @Param("centre") String centre, @Param("ddate") Date ddate,@Param("flag") Boolean flag);

    void InvalidDocumentDelete(@Param("centre")String centre);

    Page<SfpFile> searchListPageHelper(SearchVo searchVo);

    int updateByPrimaryKeySelective(SfpFile record);
}
