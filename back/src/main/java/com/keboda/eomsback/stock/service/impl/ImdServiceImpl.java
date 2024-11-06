package com.keboda.eomsback.stock.service.impl;

import com.keboda.eomsback.entity.SearchVo;
import com.keboda.eomsback.stock.mapper.ImdFileMapper;
import com.keboda.eomsback.stock.pojo.ImdFile;
import com.keboda.eomsback.stock.service.IImdService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ImdServiceImpl  implements IImdService {

    @Resource
    private ImdFileMapper imdFileMapper;

    @Override
    public List<ImdFile> searchImdList(SearchVo searchVo) {
        return imdFileMapper.searchImdList(searchVo);
    }
}
