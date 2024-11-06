package com.keboda.eomsback.purchase.service.impl;

import com.keboda.eomsback.entity.SearchVo;
import com.keboda.eomsback.purchase.mapper.PmjFileMapper;
import com.keboda.eomsback.purchase.pojo.PmjFile;
import com.keboda.eomsback.purchase.service.IPmjService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PmjServiceImpl implements IPmjService {

    @Resource
    private PmjFileMapper pmjFileMapper;


    @Override
    public List<PmjFile> searchListByOrderCode(SearchVo searchVo) {
        return pmjFileMapper.searchListByOrderCode(searchVo);
    }

    @Override
    public void updateInvalidityTime(PmjFile pmjFile) {
        pmjFileMapper.updateByPrimaryKeySelective(pmjFile);
    }
}
