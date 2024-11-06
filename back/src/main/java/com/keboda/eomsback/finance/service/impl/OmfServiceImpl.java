package com.keboda.eomsback.finance.service.impl;

import com.keboda.eomsback.entity.SearchVo;
import com.keboda.eomsback.finance.mapper.OmfFileMapper;
import com.keboda.eomsback.finance.pojo.OmfFile;
import com.keboda.eomsback.finance.pojo.RpaVo;
import com.keboda.eomsback.finance.service.IOmfService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class OmfServiceImpl implements IOmfService {

    @Resource
    private OmfFileMapper omfFileMapper;

    @Override
    public RpaVo selectOmfByRpa(SearchVo searchVo) {
        RpaVo rpaVo =  omfFileMapper.selectOmfByRpa(searchVo);
        if(rpaVo != null) {
            List<OmfFile> list = omfFileMapper.selectMaterialNum(searchVo);
            Map<String, BigDecimal> map = list.stream()
                    .collect(Collectors.toMap(OmfFile::getOmf13, OmfFile::getOmf19x));
            rpaVo.setMaterialNum(map);
        }

        return rpaVo;
    }
}
