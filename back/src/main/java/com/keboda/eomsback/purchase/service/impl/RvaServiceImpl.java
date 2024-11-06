package com.keboda.eomsback.purchase.service.impl;

import com.github.pagehelper.Page;
import com.keboda.eomsback.entity.SearchVo;
import com.keboda.eomsback.purchase.mapper.RvaFileMapper;
import com.keboda.eomsback.purchase.pojo.RvaFile;
import com.keboda.eomsback.purchase.service.IRvaService;
import com.keboda.eomsback.stock.service.ITlfService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class RvaServiceImpl implements IRvaService {

    @Resource
    private RvaFileMapper rvaFileMapper;
    @Resource
    private ITlfService iTlfService;

    @Override
    public Page<RvaFile> searchListPageHelper(SearchVo searchVo) {
        return rvaFileMapper.searchListPageHelper(searchVo);
    }

    /**
     * 修改收货单表头
     * @param rvaFile
     */
    @Override
    @Transactional
    public void updateConf(RvaFile rvaFile) {
        rvaFileMapper.updateByPrimaryKeySelective(rvaFile);
    }


    @Override
    @Transactional
    public void updateDate(RvaFile rvaFile) {
        RvaFile rva = new RvaFile();
        rva.setCentre(rvaFile.getCentre());
        rva.setRva01(rvaFile.getRva01());
        rva.setRva06(rvaFile.getRva06());
        rva.setRvadate(rvaFile.getRva06());
        rva.setRvaud13(rvaFile.getRva06());
        rva.setRvaud14(rvaFile.getRva06());
        rva.setRvacond(rvaFile.getRva06());
        rva.setRvacrat(rvaFile.getRva06());
        rvaFileMapper.updateByPrimaryKeySelective(rva);
        iTlfService.alterByCode(rvaFile.getCentre(),rvaFile.getRva02(),rvaFile.getRva01(),"0",rvaFile.getRva06(),null,null);
    }
}
