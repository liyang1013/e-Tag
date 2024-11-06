package com.keboda.eomsback.finance.service;

import com.keboda.eomsback.entity.SearchVo;
import com.keboda.eomsback.finance.pojo.RpaVo;

public interface IOmaService {
    RpaVo selectOmbByRpa(SearchVo searchVo);
}
