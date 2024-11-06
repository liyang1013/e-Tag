package com.keboda.eomsback.sale.service.impl;

import com.github.pagehelper.Page;
import com.keboda.eomsback.entity.SearchVo;
import com.keboda.eomsback.sale.mapper.OhaFileMapper;
import com.keboda.eomsback.sale.mapper.OhbFileMapper;
import com.keboda.eomsback.sale.pojo.OhaFile;
import com.keboda.eomsback.sale.pojo.OhbFile;
import com.keboda.eomsback.sale.service.IOhaService;
import com.keboda.eomsback.stock.service.ITlfService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OhaServiceImpl implements IOhaService {

    @Resource
    private OhaFileMapper ohaFileMapper;
    @Resource
    private OhbFileMapper ohbFileMapper;
    @Resource
    private ITlfService iTlfService;

    @Override
    public Page<OhaFile> searchOhaListPageHelper(SearchVo searchVo) {
        return ohaFileMapper.searchOhaListPageHelper(searchVo);
    }

    @Override
    public List<OhbFile> searchOhbList(SearchVo searchVo) {
        return ohbFileMapper.searchOhbList(searchVo);
    }

    @Override
    @Transactional
    public void alterOhaDate(OhaFile ohaFile) {
        ohaFileMapper.alterOhaDate(ohaFile);
        iTlfService.alterByCode(ohaFile.getCentre(),ohaFile.getOha01(),ohaFile.getOha01(),"1",ohaFile.getOha02(),null,null);
    }
}
