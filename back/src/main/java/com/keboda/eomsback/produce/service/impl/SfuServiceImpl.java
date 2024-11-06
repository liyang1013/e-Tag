package com.keboda.eomsback.produce.service.impl;

import com.github.pagehelper.Page;
import com.keboda.eomsback.entity.SearchVo;
import com.keboda.eomsback.produce.mapper.SfuFileMapper;
import com.keboda.eomsback.produce.mapper.SfvFileMapper;
import com.keboda.eomsback.produce.pojo.SfuFile;
import com.keboda.eomsback.produce.pojo.SfvFile;
import com.keboda.eomsback.produce.service.ISfuService;
import com.keboda.eomsback.stock.service.ITlfService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SfuServiceImpl implements ISfuService {

    @Resource
    private SfuFileMapper sfuFileMapper;
    @Resource
    private SfvFileMapper sfvFileMapper;
    @Resource
    private ITlfService iTlfService;

    @Override
    public Page<SfuFile> searchSfuListPageHelper(SearchVo searchVo) {
        return sfuFileMapper.searchSfuListPageHelper(searchVo);
    }

    @Override
    public List<SfvFile> searchSfvList(SearchVo searchVo) {
        return sfvFileMapper.searchSfvList(searchVo);
    }

    @Override
    public void updateState(SfuFile sfuFile) {
        sfuFileMapper.updateByPrimaryKeySelective(sfuFile);
    }

    @Override
    @Transactional
    public void updateDate(SfuFile sfuFile) {
        sfuFileMapper.updateByPrimaryKeySelective(sfuFile);
        if(sfuFile.getSfu00().equals("1"))
            iTlfService.alterByCode(sfuFile.getCentre(),null,sfuFile.getSfu01(),"1",sfuFile.getSfu02(),null,null);
        else iTlfService.alterByCode(sfuFile.getCentre(),sfuFile.getSfu01(),null,"-1",sfuFile.getSfu02(),null,null);

    }
}
