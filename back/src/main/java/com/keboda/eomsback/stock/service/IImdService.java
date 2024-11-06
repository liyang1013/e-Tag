package com.keboda.eomsback.stock.service;

import com.keboda.eomsback.entity.SearchVo;
import com.keboda.eomsback.stock.pojo.ImdFile;

import java.util.List;

public interface IImdService {
    List<ImdFile> searchImdList(SearchVo searchVo);
}
