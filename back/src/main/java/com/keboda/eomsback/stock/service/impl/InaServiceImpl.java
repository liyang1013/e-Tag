package com.keboda.eomsback.stock.service.impl;

import com.github.pagehelper.Page;
import com.keboda.eomsback.entity.SearchVo;
import com.keboda.eomsback.stock.mapper.InaFileMapper;
import com.keboda.eomsback.stock.mapper.InbFileMapper;
import com.keboda.eomsback.stock.mapper.TlfFileMapper;
import com.keboda.eomsback.stock.pojo.InaFile;
import com.keboda.eomsback.stock.pojo.InbFile;
import com.keboda.eomsback.stock.service.IInaService;
import com.keboda.eomsback.stock.service.ITlfService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class InaServiceImpl implements IInaService {

    @Resource
    private InaFileMapper inaFileMapper;
    @Resource
    private ITlfService iTlfService;
    @Resource
    private InbFileMapper inbFileMapper;


    @Override
    public Page<InaFile> searchListPageHelper(SearchVo searchVo) {
        return inaFileMapper.searchListPageHelper(searchVo);
    }

    @Override
    @Transactional
    public void alterGem(InaFile inaFile) {
        inaFileMapper.alterGem(inaFile);
        iTlfService.alterByCode(inaFile.getCentre(),inaFile.getIna01(),inaFile.getIna01(),null,null, inaFile.getIna04(),null);
    }

    @Override
    public List<InbFile> searchSlaveList(SearchVo searchVo) {
        return inbFileMapper.searchSlaveList(searchVo);
    }

    @Override
    @Transactional
    public void alterAzf(InbFile inbFile) {
        inbFileMapper.alterAzf(inbFile);
        iTlfService.alterByRow(inbFile.getCentre(),inbFile.getInb01(),inbFile.getInb03(), inbFile.getInb01(),inbFile.getInb03(),null, inbFile.getInb15(),null);
    }

    @Override
    @Transactional
    public void alterPja(InaFile inaFile) {
        inaFileMapper.alterPja(inaFile);
        inbFileMapper.alterPja(inaFile);
        iTlfService.alterByCode(inaFile.getCentre(),inaFile.getIna01(),inaFile.getIna01(),null,null, null,inaFile.getIna06());
    }

    @Override
    @Transactional
    public void alterPjb(InbFile inbFile) {
        inbFileMapper.alterPjb(inbFile);
        iTlfService.alterByRow(inbFile.getCentre(),inbFile.getInb01(),inbFile.getInb03(), inbFile.getInb01(),inbFile.getInb03(),null,null, inbFile.getInb42());

    }

    @Override
    @Transactional
    public void alterConf(InaFile inaFile) {
        inaFileMapper.alterConf(inaFile);
    }
}
