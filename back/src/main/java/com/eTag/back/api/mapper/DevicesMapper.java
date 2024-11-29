package com.eTag.back.api.mapper;

import com.eTag.back.api.pojo.Devices;
import com.eTag.back.entity.SearchVo;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DevicesMapper {

    int insertSelective(Devices record);

    Page<Devices> searchDevicePageHelper(SearchVo searchVo);

    Devices selectByClientId(@Param("clientId") String clientId, @Param("status") Boolean status);

    void updateSelective(Devices update);

    void deleteByClientId(String clientId);

    void deleteByUid(Integer uid);

    void updateDeviceLastTime(String clientId);
}