package com.keboda.eomsback.sale.service.impl;

import com.github.pagehelper.Page;
import com.keboda.eomsback.entity.SearchVo;
import com.keboda.eomsback.purchase.pojo.RvuFile;
import com.keboda.eomsback.sale.mapper.OgaFileMapper;
import com.keboda.eomsback.sale.mapper.OgbFileMapper;
import com.keboda.eomsback.sale.pojo.OgaFile;
import com.keboda.eomsback.sale.pojo.OgbFile;
import com.keboda.eomsback.sale.service.IOgaService;
import com.keboda.eomsback.stock.service.ITlfService;
import com.keboda.eomsback.stock.service.impl.TlfServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OgaServiceImpl implements IOgaService {

    @Resource
    private OgaFileMapper ogaFileMapper;
    @Resource
    private OgbFileMapper ogbFileMapper;
    @Resource
    private ITlfService iTlfService;

    @Override
    public Page<OgaFile> searchOgaListPageHelper(SearchVo searchVo) {
        return ogaFileMapper.searchOgaListPageHelper(searchVo);
    }

    @Override
    public List<OgbFile> searchOgbList(SearchVo searchVo) {
        return ogbFileMapper.searchOgbList(searchVo);
    }

    @Override
    @Transactional
    public void alterOgaDate(OgaFile ogaFile) {
        ogaFileMapper.alterOgaDate(ogaFile);
        iTlfService.alterByCode(ogaFile.getCentre(),ogaFile.getOga01(),null,"-1",ogaFile.getOga02(),null,null);
    }
}
