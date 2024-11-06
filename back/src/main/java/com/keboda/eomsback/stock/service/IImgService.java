package com.keboda.eomsback.stock.service;

import com.github.pagehelper.Page;
import com.keboda.eomsback.entity.SearchVo;
import com.keboda.eomsback.stock.pojo.ImgFile;

public interface IImgService {
    Page<ImgFile> searchImgListPageHelper(SearchVo searchVo);

    void repairImg(SearchVo searchVo);
}
