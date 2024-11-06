package com.keboda.eomsback.purchase.service.impl;

import com.github.pagehelper.Page;
import com.keboda.eomsback.entity.SearchVo;
import com.keboda.eomsback.purchase.mapper.PmiFileMapper;
import com.keboda.eomsback.purchase.mapper.PmjFileMapper;
import com.keboda.eomsback.purchase.pojo.PmiFile;
import com.keboda.eomsback.purchase.service.IPmiService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PmiServiceImpl implements IPmiService {

    @Resource
    private PmiFileMapper pmiFileMapper;
    @Resource
    private PmjFileMapper pmjFileMapper;


    @Override
    public Page<PmiFile> searchListPageHelper(SearchVo searchVo) {
        return pmiFileMapper.searchListPageHelper(searchVo);
    }

    @Override
    @Transactional
    public String deleteDocument(List<PmiFile> pmiFileList) {
        pmiFileList.forEach(e -> {
            pmjFileMapper.deleteByPrimaryKey(e.getPmi01(),e.getCentre());
            pmiFileMapper.deleteByPrimaryKey(e.getPmi01(),e.getCentre());
        });

        return "删除成功";
    }

}
