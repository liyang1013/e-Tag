package com.keboda.eomsback.finance.service;

import com.keboda.eomsback.entity.SearchVo;
import com.keboda.eomsback.finance.pojo.RpaVo;

import java.util.List;

public interface IOmfService {
    RpaVo selectOmfByRpa(SearchVo searchVo);
}
