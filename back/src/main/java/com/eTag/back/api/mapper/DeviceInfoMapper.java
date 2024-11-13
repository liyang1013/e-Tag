package com.eTag.back.api.mapper;

import com.eTag.back.api.pojo.DeviceInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeviceInfoMapper {
    int insertSelective(DeviceInfo record);

    List<DeviceInfo> searchDeviceInfo();

    void deleteDevice(DeviceInfo deviceInfo);
}