package com.keboda.eomsback.system.service;

import com.github.pagehelper.Page;
import com.keboda.eomsback.authorityReview.pojo.AuthorityRecordsVo;
import com.keboda.eomsback.entity.SearchVo;
import com.keboda.eomsback.system.pojo.ZwFile;
import com.keboda.eomsback.system.pojo.ZxwFile;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IZxwService {

    List<AuthorityRecordsVo> searchRecordsList(String code);
}
