package com.eTag.back.api.controller;

import com.eTag.back.api.pojo.DeviceInfo;
import com.eTag.back.api.service.IDeviceInfoService;
import com.eTag.back.entity.BaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/device")
public class DeviceController {

    @Autowired
    private IDeviceInfoService iDeviceInfoService;

    @GetMapping("/searchDeviceInfo")
    public BaseResult searchDeviceInfo(){
        return BaseResult.success(iDeviceInfoService.searchDeviceInfo());
    }

    @PostMapping("/addDevice")
    public BaseResult addDevice(@RequestBody DeviceInfo deviceInfo){
        iDeviceInfoService.addDevice(deviceInfo);
        return BaseResult.success();
    }

    @PostMapping("/deleteDevice")
    public BaseResult deleteDevice(@RequestBody DeviceInfo deviceInfo){
        iDeviceInfoService.deleteDevice(deviceInfo);
        return BaseResult.success();
    }

}
