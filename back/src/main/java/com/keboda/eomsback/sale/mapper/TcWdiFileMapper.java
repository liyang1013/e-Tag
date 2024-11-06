package com.keboda.eomsback.sale.mapper;

import com.github.pagehelper.Page;
import com.keboda.eomsback.entity.SearchVo;
import com.keboda.eomsback.sale.pojo.TcWdiFile;

public interface TcWdiFileMapper {
    int insertSelective(TcWdiFile record);

    Page<TcWdiFile> searchWdiListPageHelper(SearchVo searchVo);
}