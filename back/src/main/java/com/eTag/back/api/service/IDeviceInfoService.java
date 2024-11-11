package com.eTag.back.api.service;

import com.eTag.back.api.pojo.DeviceInfo;

import java.util.List;

public interface IDeviceInfoService {
    List<DeviceInfo> searchDeviceInfo();

    void addDevice(DeviceInfo deviceInfo);
}
