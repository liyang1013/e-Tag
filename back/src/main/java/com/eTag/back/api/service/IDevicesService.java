package com.eTag.back.api.service;

import com.eTag.back.api.pojo.Devices;
import com.eTag.back.entity.SearchVo;
import com.github.pagehelper.Page;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface IDevicesService {
    Page<Devices> searchDevicePageHelper(SearchVo searchVo);

    String uploadFile(MultipartFile file) throws IOException;

    void addLabel(Devices devices);

    void deleteDevice(Devices devices);
}
