package com.eTag.back.api.service.impl;

import cn.hutool.http.Header;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import com.eTag.back.api.mapper.DeviceInfoMapper;
import com.eTag.back.api.pojo.DeviceInfo;
import com.eTag.back.api.service.IDeviceInfoService;
import com.eTag.back.utils.SocketUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DeviceInfoServiceImpl implements IDeviceInfoService {

    @Resource
    private DeviceInfoMapper deviceInfoMapper;


    @Override
    public List<DeviceInfo> searchDeviceInfo() {
        return deviceInfoMapper.searchDeviceInfo();
    }

    @Override
    public void addDevice(DeviceInfo deviceInfo) {
        if (!SocketUtils.isReachable(deviceInfo.getIp(), 80))
            throw new RuntimeException("网络错误，请检查IP地址是否正确填写");

        try {
            HttpResponse res = HttpRequest.post("http://" + deviceInfo.getIp() + "/Iotags")
                    .header(Header.CONTENT_TYPE, "application/x-www-form-urlencoded; charset=UTF-8")
                    .header(Header.ACCEPT, "*/*")
                    .timeout(20000)
                    .execute();
            System.out.println(res);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
