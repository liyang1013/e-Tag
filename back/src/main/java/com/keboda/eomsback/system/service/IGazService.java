package com.keboda.eomsback.system.service;

import com.github.pagehelper.Page;
import com.keboda.eomsback.entity.SearchVo;
import com.keboda.eomsback.system.pojo.GazFile;

public interface IGazService {

    GazFile selectByPrimaryKey(String gaz01);

    Page<GazFile> searchGazListPageHelper(SearchVo searchVo);
}
