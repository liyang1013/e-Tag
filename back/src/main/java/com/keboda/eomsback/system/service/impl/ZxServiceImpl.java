package com.keboda.eomsback.system.service.impl;

import com.github.pagehelper.Page;
import com.keboda.eomsback.authorityReview.pojo.PersonalPosition;
import com.keboda.eomsback.entity.SearchVo;
import com.keboda.eomsback.system.mapper.ZxFileMapper;
import com.keboda.eomsback.system.pojo.ZxFile;
import com.keboda.eomsback.system.service.IZxService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ZxServiceImpl implements IZxService {

    @Resource
    private ZxFileMapper zxFileMapper;

    @Override
    public Page<ZxFile> searchListPageHelper(SearchVo searchVo) {
        return zxFileMapper.searchListPageHelper(searchVo);
    }

    @Override
    public ZxFile selectByPrimaryKey(String zx01) {
        return zxFileMapper.selectByPrimaryKey(zx01);
    }

    @Override
    public Page<PersonalPosition> searchPersonalPositionContrastRecordsListPageHelper(SearchVo searchVo) {
        return zxFileMapper.searchPersonalPositionContrastRecordsListPageHelper(searchVo);
    }

    @Override
    public List<PersonalPosition> personalPositionContrastRecords(Integer itype) {
        return zxFileMapper.personalPositionContrastRecords(itype);
    }
}
