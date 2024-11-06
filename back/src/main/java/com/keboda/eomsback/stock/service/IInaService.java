package com.keboda.eomsback.stock.service;

import com.github.pagehelper.Page;
import com.keboda.eomsback.entity.SearchVo;
import com.keboda.eomsback.stock.pojo.InaFile;
import com.keboda.eomsback.stock.pojo.InbFile;

import java.util.List;

public interface IInaService {
    Page<InaFile> searchListPageHelper(SearchVo searchVo);

    void alterGem(InaFile inaFile);

    List<InbFile> searchSlaveList(SearchVo searchVo);

    void alterAzf(InbFile inbFile);

    void alterPja(InaFile inaFile);

    void alterPjb(InbFile inbFile);

    void alterConf(InaFile inaFile);
}
