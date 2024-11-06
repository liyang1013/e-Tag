package com.keboda.eomsback.sale.service.impl;

import com.github.pagehelper.Page;
import com.keboda.eomsback.entity.SearchVo;
import com.keboda.eomsback.sale.mapper.TcWdiFileMapper;
import com.keboda.eomsback.sale.mapper.TcWdjFileMapper;
import com.keboda.eomsback.sale.mapper.TcWdjaFileMapper;
import com.keboda.eomsback.sale.pojo.TcWdiFile;
import com.keboda.eomsback.sale.pojo.TcWdjFile;
import com.keboda.eomsback.sale.service.IWdiService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class WdiServiceImpl implements IWdiService {

    @Resource
    private TcWdiFileMapper tcWdiFileMapper;

    @Resource
    private TcWdjFileMapper tcWdjFileMapper;


    @Override
    public Page<TcWdiFile> searchWdiListPageHelper(SearchVo searchVo) {
        return tcWdiFileMapper.searchWdiListPageHelper(searchVo);
    }

    @Override
    public List<TcWdjFile> searchWdjList(SearchVo searchVo) {
        return tcWdjFileMapper.searchWdjList(searchVo);
    }

    @Override
    @Transactional
    public void repairWdj(TcWdjFile tcWdjFile) {
        tcWdjFileMapper.repairWdj(tcWdjFile);
    }
}
