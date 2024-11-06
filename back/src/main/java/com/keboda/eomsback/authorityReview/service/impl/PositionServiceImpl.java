package com.keboda.eomsback.authorityReview.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.github.pagehelper.Page;
import com.keboda.eomsback.authorityReview.mapper.ActionMenuMapper;
import com.keboda.eomsback.authorityReview.mapper.PositionMapper;
import com.keboda.eomsback.authorityReview.pojo.AuthorityRecordsVo;
import com.keboda.eomsback.authorityReview.pojo.Position;
import com.keboda.eomsback.authorityReview.service.IPositionService;
import com.keboda.eomsback.entity.SearchVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@DS("myself")
public class PositionServiceImpl implements IPositionService {

    @Resource
    private PositionMapper positionMapper;

    @Override
    public Page<AuthorityRecordsVo> searchPositionRecordsListPageHelper(SearchVo searchVo,String[] exclude) {
        return positionMapper.searchPositionRecordsListPageHelper(searchVo,exclude);
    }

    @Override
    public Integer merge(String positionCode, String positionName, String year) {

        Position position = positionMapper.selectByPrimaryKey(year,positionCode);
        if(position == null){
            position = new Position();
            position.setYear(Integer.valueOf(year));
            position.setPositionCode(positionCode);
            position.setPositionName(positionName);
            position.setUuid(positionMapper.insertSelective(position));
        }
        return position.getUuid();
    }
}
