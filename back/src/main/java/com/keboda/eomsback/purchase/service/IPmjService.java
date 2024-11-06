package com.keboda.eomsback.purchase.service;

import com.keboda.eomsback.entity.SearchVo;
import com.keboda.eomsback.purchase.pojo.PmjFile;

import java.util.List;

public interface IPmjService {

    List<PmjFile> searchListByOrderCode(SearchVo searchVo);

    void updateInvalidityTime(PmjFile pmjFile);
}
