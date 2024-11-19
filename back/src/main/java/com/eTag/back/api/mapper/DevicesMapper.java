package com.eTag.back.api.mapper;

import com.eTag.back.api.pojo.Devices;
import com.eTag.back.entity.SearchVo;
import com.github.pagehelper.Page;
import org.springframework.stereotype.Repository;

@Repository
public interface DevicesMapper {

    int insertSelective(Devices record);

    Page<Devices> searchDevicePageHelper(SearchVo searchVo);
}