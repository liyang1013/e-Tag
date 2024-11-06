package com.keboda.eomsback.stock.service;

import com.github.pagehelper.Page;
import com.keboda.eomsback.stock.pojo.ImaFile;
import com.keboda.eomsback.entity.SearchVo;
import com.keboda.eomsback.stock.pojo.ImgFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface IImaService {

    Page<ImaFile> searchListPageHelper(SearchVo searchVo);

    void updateUnit(ImaFile imaFile);

    int updateByExcel(MultipartFile file, String centre) throws IOException;

}
