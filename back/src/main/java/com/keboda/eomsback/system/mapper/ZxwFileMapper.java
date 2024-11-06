package com.keboda.eomsback.system.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.github.pagehelper.Page;
import com.keboda.eomsback.authorityReview.pojo.AuthorityRecordsVo;
import com.keboda.eomsback.entity.SearchVo;
import com.keboda.eomsback.system.pojo.Authority;
import com.keboda.eomsback.system.pojo.Department;
import com.keboda.eomsback.system.pojo.ZxwFile;
import com.keboda.eomsback.system.pojo.ZxwFileKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ZxwFileMapper {

    int insertSelective(ZxwFile record);

    int updateByPrimaryKeySelective(ZxwFile record);

    List<AuthorityRecordsVo> searchRecordsList(@Param("code") String code, @Param("amountTags") String[] amountTags,@Param("createTags") String[] createTags,
            @Param("deleteTags") String[] deleteTags,@Param("updateTags") String[] updateTags,@Param("readTags") String[] readTags,@Param("confirmTags") String[] confirmTags,
            @Param("unConfirmTags") String[] unConfirmTags,@Param("voidTags") String[] voidTags,@Param("unVoidTags") String[] unVoidTags,@Param("postTags") String[] postTags,
            @Param("unPostTags") String[] unPostTags,@Param("exclude")String[] exclude);

}