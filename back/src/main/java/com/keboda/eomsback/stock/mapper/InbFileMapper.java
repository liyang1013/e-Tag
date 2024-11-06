package com.keboda.eomsback.stock.mapper;

import com.keboda.eomsback.entity.SearchVo;
import com.keboda.eomsback.stock.pojo.InaFile;
import com.keboda.eomsback.stock.pojo.InbFile;
import com.keboda.eomsback.stock.pojo.InbFileKey;

import java.util.List;

public interface InbFileMapper {
    int insertSelective(InbFile record);

    int updateByPrimaryKeySelective(InbFile record);

    List<InbFile> searchSlaveList(SearchVo searchVo);

    void alterAzf(InbFile inbFile);

    void alterPja(InaFile inaFile);

    void alterPjb(InbFile inbFile);
}