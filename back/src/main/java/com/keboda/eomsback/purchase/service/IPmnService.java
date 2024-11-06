package com.keboda.eomsback.purchase.service;

import com.keboda.eomsback.entity.SearchVo;
import com.keboda.eomsback.purchase.pojo.PmnFile;

import java.util.List;

public interface IPmnService {

    void closeOut(PmnFile pmnFile);

    List<PmnFile> searchListByOrderCode(SearchVo searchVo);
}
