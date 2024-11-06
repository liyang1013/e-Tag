package com.keboda.eomsback.purchase.service;

import com.keboda.eomsback.entity.SearchVo;
import com.keboda.eomsback.purchase.pojo.RvvFile;

import java.util.List;

public interface IRvvService {
    List<RvvFile> searchListByOrderCode(SearchVo searchVo);
}
