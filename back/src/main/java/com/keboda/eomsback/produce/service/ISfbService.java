package com.keboda.eomsback.produce.service;

import com.github.pagehelper.Page;
import com.keboda.eomsback.entity.SearchVo;
import com.keboda.eomsback.produce.pojo.SfaFile;
import com.keboda.eomsback.produce.pojo.SfbFile;
import com.keboda.eomsback.produce.pojo.vo.SfbModify;
import com.keboda.eomsback.produce.pojo.vo.SfbStatusVo;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

public interface ISfbService {
    List<SfbFile> searchSfbList(SearchVo searchVo);

    SfbStatusVo searchSfbStatus(SearchVo searchVo) throws RuntimeException;

    Page<SfbFile> searchSfbListPageHelper(SearchVo searchVo);

    void modifySfbDate(SfbModify sfbModify, HttpServletRequest request);

    void closeOut(List<SfbFile> sfbFiles);

    List<SfaFile> searchSfaList(SearchVo searchVo);

    int updateDepartment(SfbFile sfbFile);

    void isFQC(SfbFile sfbFile);

    int updateByExcel(MultipartFile file, String centre) throws IOException;

    void updateFL(SfbFile sfbFile);

    void updateRK(SfbFile sfbFile);

    void updateBF(SfbFile sfbFile);

    void updateProductionLine(SfbFile sfbFile);
}
