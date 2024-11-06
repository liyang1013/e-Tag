package com.keboda.eomsback.system.service.impl;

import com.keboda.eomsback.entity.SearchVo;
import com.keboda.eomsback.system.mapper.AzfFileMapper;
import com.keboda.eomsback.system.pojo.AzfFile;
import com.keboda.eomsback.system.service.IAzfService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AzfServiceImpl implements IAzfService {

    @Resource
    private AzfFileMapper azfFileMapper;

    @Override
    public List<AzfFile> searchAzfList(SearchVo searchVo) {
        return azfFileMapper.searchAzfList(searchVo);
    }

    @Override
    public AzfFile searchAzfByKey(SearchVo searchVo) {
        return azfFileMapper.searchAzfByKey(searchVo);
    }
}
