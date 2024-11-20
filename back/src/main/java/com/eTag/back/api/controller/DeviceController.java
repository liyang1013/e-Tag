package com.eTag.back.api.controller;

import com.eTag.back.api.pojo.Devices;
import com.eTag.back.api.service.IDevicesService;
import com.eTag.back.entity.BaseResult;
import com.eTag.back.entity.SearchVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/device")
public class DeviceController {
    @Autowired
    private IDevicesService iDevicesService;

    @PostMapping("/searchDevicePageHelper")
    public BaseResult searchDevicePageHelper(@RequestBody SearchVo searchVo) {
        PageHelper.startPage(searchVo.getCurrentPage(), searchVo.getSize());
        Page<Devices> page = iDevicesService.searchDevicePageHelper(searchVo);
        return BaseResult.success(page, page.getTotal());
    }

    @PostMapping("/uploadFile")
    public BaseResult uploadFile(MultipartFile file) throws IOException {
       return BaseResult.success(iDevicesService.uploadFile(file));
    }

    @PostMapping("/addLabel")
    public BaseResult addLabel(@RequestBody Devices devices)  {
        iDevicesService.addLabel(devices);
        return BaseResult.success();
    }

    @PostMapping("/deleteDevice")
    public BaseResult deleteDevice(@RequestBody Devices devices){
        iDevicesService.deleteDevice(devices);
        return BaseResult.success();
    }
}
