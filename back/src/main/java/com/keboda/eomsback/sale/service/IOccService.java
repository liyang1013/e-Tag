package com.keboda.eomsback.sale.service;

import com.github.pagehelper.Page;
import com.keboda.eomsback.entity.SearchVo;
import com.keboda.eomsback.sale.pojo.OccFile;

public interface IOccService {
    Page<OccFile> searchOccListPageHelper(SearchVo searchVo);
}
