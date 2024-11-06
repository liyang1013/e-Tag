package com.keboda.eomsback.purchase.service.impl;

import com.keboda.eomsback.entity.SearchVo;
import com.keboda.eomsback.purchase.mapper.PmnFileMapper;
import com.keboda.eomsback.purchase.pojo.PmnFile;
import com.keboda.eomsback.purchase.service.IPmnService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PmnServiceImpl implements IPmnService {

    @Resource
    private PmnFileMapper pmnFileMapper;

    @Override
    public void closeOut(PmnFile pmnFile) {
        pmnFileMapper.updateByPrimaryKeySelective(pmnFile);
    }

    @Override
    public List<PmnFile> searchListByOrderCode(SearchVo searchVo) {
        return pmnFileMapper.searchListByOrderCode(searchVo);
    }

}
