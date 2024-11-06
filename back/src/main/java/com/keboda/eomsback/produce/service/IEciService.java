package com.keboda.eomsback.produce.service;

import com.keboda.eomsback.entity.SearchVo;
import com.keboda.eomsback.produce.pojo.EciFile;

import java.util.List;

public interface IEciService {
    List<EciFile> searchEciList(SearchVo searchVo);


    EciFile searchEciByKey(SearchVo searchVo);
}
