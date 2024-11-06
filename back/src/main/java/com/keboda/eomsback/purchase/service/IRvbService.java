package com.keboda.eomsback.purchase.service;

import com.keboda.eomsback.entity.SearchVo;
import com.keboda.eomsback.purchase.pojo.RvbFile;

import java.util.List;

public interface IRvbService {

    List<RvbFile> searchListByOrderCode(SearchVo searchVo);

}
