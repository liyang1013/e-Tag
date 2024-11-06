package com.keboda.eomsback.purchase.service.impl;

import com.github.pagehelper.Page;
import com.keboda.eomsback.entity.SearchVo;
import com.keboda.eomsback.purchase.mapper.PmmFileMapper;
import com.keboda.eomsback.purchase.pojo.PmmFile;
import com.keboda.eomsback.purchase.pojo.PmnFile;
import com.keboda.eomsback.purchase.service.IPmmService;
import com.keboda.eomsback.purchase.service.IPmnService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PmmServiceImpl implements IPmmService {

    @Resource
    private PmmFileMapper pmmFileMapper;
    @Resource
    IPmnService iPmnService;

    @Override
    public Page<PmmFile> searchListPageHelper(SearchVo searchVo) {
        return pmmFileMapper.searchListPageHelper(searchVo);
    }

    @Override
    @Transactional
    public void closeOut(List<PmmFile> pmmFileList) {
        for (PmmFile pmmFile : pmmFileList) {

            PmmFile pmm = new PmmFile();
            pmm.setCentre(pmmFile.getCentre());
            pmm.setPmm01(pmmFile.getPmm01());
            pmm.setPmm25("6");
            pmmFileMapper.updateByPrimaryKeySelective(pmm);


            PmnFile pmnFile = new PmnFile();
            pmnFile.setCentre(pmmFile.getCentre());
            pmnFile.setPmn01(pmmFile.getPmm01());
            pmnFile.setPmn16("6");
            iPmnService.closeOut(pmnFile);
        }
    }
}
