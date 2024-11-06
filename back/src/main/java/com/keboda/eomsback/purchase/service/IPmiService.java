package com.keboda.eomsback.purchase.service;

import com.github.pagehelper.Page;
import com.keboda.eomsback.entity.SearchVo;
import com.keboda.eomsback.purchase.pojo.PmiFile;

import java.util.List;

public interface IPmiService {
    Page<PmiFile> searchListPageHelper(SearchVo searchVo);

    String deleteDocument(List<PmiFile> pmiFileList);
}
