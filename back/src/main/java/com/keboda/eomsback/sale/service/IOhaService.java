package com.keboda.eomsback.sale.service;

import com.github.pagehelper.Page;
import com.keboda.eomsback.entity.SearchVo;
import com.keboda.eomsback.sale.pojo.OhaFile;
import com.keboda.eomsback.sale.pojo.OhbFile;

import java.util.List;

public interface IOhaService {
    Page<OhaFile> searchOhaListPageHelper(SearchVo searchVo);

    List<OhbFile> searchOhbList(SearchVo searchVo);

    void alterOhaDate(OhaFile ohaFile);
}
