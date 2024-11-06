package com.keboda.eomsback.produce.service.impl;

import com.github.pagehelper.Page;
import com.keboda.eomsback.entity.SearchVo;
import com.keboda.eomsback.produce.mapper.SfeFileMapper;
import com.keboda.eomsback.produce.mapper.SfpFileMapper;
import com.keboda.eomsback.produce.mapper.SfsFileMapper;
import com.keboda.eomsback.produce.pojo.SfpFile;
import com.keboda.eomsback.produce.pojo.SfsFile;
import com.keboda.eomsback.produce.service.ISfpService;
import com.keboda.eomsback.stock.mapper.TlfFileMapper;
import com.keboda.eomsback.stock.service.ITlfService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SfpServiceImpl implements ISfpService {

    @Resource
    private SfpFileMapper sfpFileMapper;
    @Resource
    private SfsFileMapper sfsFileMapper;
    @Resource
    private ITlfService iTlfService;

    @Override
    public Page<SfpFile> searchListPageHelper(SearchVo searchVo) {
        return sfpFileMapper.searchListPageHelper(searchVo);
    }

    @Override
    public List<SfsFile> searchSlaveList(SearchVo searchVo) {
        return sfsFileMapper.searchSlaveList(searchVo);
    }

    @Override
    @Transactional
    public void updateState(SfpFile sfpFile) {
        sfpFileMapper.updateByPrimaryKeySelective(sfpFile);
    }

    @Override
    @Transactional
    public void updateUnit(SfsFile sfsFile) {
        sfsFileMapper.updateByPrimaryKeySelective(sfsFile);
    }

    @Override
    @Transactional
    public void updateDate(SfpFile sfpFile) {
        sfpFileMapper.updateByPrimaryKeySelective(sfpFile);

        if(sfpFile.getSfp06().equals("1") || sfpFile.getSfp06().equals("2") || sfpFile.getSfp06().equals("3") || sfpFile.getSfp06().equals("4"))
            iTlfService.alterByCode(sfpFile.getCentre(), sfpFile.getSfp01(), null, "-1", sfpFile.getSfp03(), null, null);
        else iTlfService.alterByCode(sfpFile.getCentre(),null, sfpFile.getSfp01(),"1", sfpFile.getSfp03(),null,null);

    }
}
