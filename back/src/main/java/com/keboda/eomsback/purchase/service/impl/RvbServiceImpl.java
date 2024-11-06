package com.keboda.eomsback.purchase.service.impl;

import com.keboda.eomsback.entity.SearchVo;
import com.keboda.eomsback.purchase.mapper.RvbFileMapper;
import com.keboda.eomsback.purchase.pojo.RvaFile;
import com.keboda.eomsback.purchase.pojo.RvbFile;
import com.keboda.eomsback.purchase.service.IRvbService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

@Service
public class RvbServiceImpl implements IRvbService {

    @Resource
    private RvbFileMapper rvbFileMapper;


    @Override
    public List<RvbFile> searchListByOrderCode(SearchVo searchVo) {
        return rvbFileMapper.searchListByOrderCode(searchVo);
    }

}
