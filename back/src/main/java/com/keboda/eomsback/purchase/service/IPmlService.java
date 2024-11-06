package com.keboda.eomsback.purchase.service;

import com.keboda.eomsback.entity.SearchVo;
import com.keboda.eomsback.purchase.pojo.PmlFile;

import java.util.List;

public interface IPmlService {

    List<PmlFile> searchListByOrderCode(SearchVo searchVo);
}
