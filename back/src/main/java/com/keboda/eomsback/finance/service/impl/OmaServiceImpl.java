package com.keboda.eomsback.finance.service.impl;

import com.keboda.eomsback.entity.SearchVo;
import com.keboda.eomsback.finance.mapper.OmbFileMapper;
import com.keboda.eomsback.finance.pojo.OmbFile;
import com.keboda.eomsback.finance.pojo.OmfFile;
import com.keboda.eomsback.finance.pojo.RpaVo;
import com.keboda.eomsback.finance.service.IOmaService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class OmaServiceImpl implements IOmaService {

    @Resource
    private OmbFileMapper ombFileMapper;

    @Override
    public RpaVo selectOmbByRpa(SearchVo searchVo) {
        RpaVo rpaVo =  ombFileMapper.selectOmbByRpa(searchVo);
        if(rpaVo != null) {
            List<OmbFile> list = ombFileMapper.selectMaterialNum(searchVo);
            Map<String, BigDecimal> map = list.stream()
                    .collect(Collectors.toMap(OmbFile::getOmb04, OmbFile::getOmb14t));
            rpaVo.setMaterialNum(map);
        }

        return rpaVo;
    }
}
