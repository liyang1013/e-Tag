package com.keboda.eomsback.purchase.service.impl;

import com.keboda.eomsback.entity.SearchVo;
import com.keboda.eomsback.purchase.mapper.RvvFileMapper;
import com.keboda.eomsback.purchase.pojo.RvvFile;
import com.keboda.eomsback.purchase.service.IRvvService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RvvServiceImpl implements IRvvService {

    @Resource
    private RvvFileMapper rvvFileMapper;


    @Override
    public List<RvvFile> searchListByOrderCode(SearchVo searchVo) {
        return rvvFileMapper.searchListByOrderCode(searchVo);
    }
}
