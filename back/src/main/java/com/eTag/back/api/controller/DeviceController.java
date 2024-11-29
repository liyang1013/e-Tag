package com.eTag.back.api.controller;

import com.eTag.back.api.pojo.Devices;
import com.eTag.back.api.pojo.LabelRequestBody;
import com.eTag.back.api.service.IDevicesService;
import com.eTag.back.entity.BaseResult;
import com.eTag.back.entity.LabelResult;
import com.eTag.back.entity.SearchVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

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

    @PostMapping("/getTemplate")
    public BaseResult getTemplate(@RequestBody Devices devices) {
        return BaseResult.success(iDevicesService.getTemplate(devices));
    }

    @PostMapping("/uploadFile")
    public BaseResult uploadFile(MultipartFile file) throws IOException {
        return BaseResult.success(iDevicesService.uploadFile(file));
    }

    @PostMapping("/enable")
    public BaseResult enable(@RequestBody Devices devices) {
        iDevicesService.enable(devices);
        return BaseResult.success(devices.getStatus() ? "开启标签" : "关闭标签");
    }

    @PostMapping("/addLabel")
    public BaseResult addLabel(@RequestBody Devices devices) {
        iDevicesService.addLabel(devices);
        return BaseResult.success();
    }

    @PostMapping("/deleteDevice")
    public BaseResult deleteDevice(@RequestBody Devices devices) {
        iDevicesService.deleteDevice(devices);
        return BaseResult.success();
    }

    @GetMapping("/getLabel")
    public LabelResult getLabel(LabelRequestBody body) {
        return LabelResult.builder().State("Done").Message("获取成功").Number("").Data(iDevicesService.getLabel(body)).build();
    }
}
