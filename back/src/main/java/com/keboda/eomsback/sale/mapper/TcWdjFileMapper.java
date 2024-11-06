package com.keboda.eomsback.sale.mapper;

import com.keboda.eomsback.entity.SearchVo;
import com.keboda.eomsback.sale.pojo.TcWdjFile;

import java.util.List;

public interface TcWdjFileMapper {
    int insertSelective(TcWdjFile record);

    List<TcWdjFile> searchWdjList(SearchVo searchVo);

    void repairWdj(TcWdjFile tcWdjFile);
}