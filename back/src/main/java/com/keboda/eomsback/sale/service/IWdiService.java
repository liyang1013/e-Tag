package com.keboda.eomsback.sale.service;

import com.github.pagehelper.Page;
import com.keboda.eomsback.entity.SearchVo;
import com.keboda.eomsback.sale.pojo.TcWdiFile;
import com.keboda.eomsback.sale.pojo.TcWdjFile;

import java.util.List;

public interface IWdiService {
    Page<TcWdiFile> searchWdiListPageHelper(SearchVo searchVo);

    List<TcWdjFile> searchWdjList(SearchVo searchVo);

    void repairWdj(TcWdjFile tcWdjFile);
}
