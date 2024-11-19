package com.eTag.back.api.service.impl;

import com.eTag.back.api.mapper.DevicesMapper;
import com.eTag.back.api.pojo.Devices;
import com.eTag.back.api.service.IDevicesService;
import com.eTag.back.entity.BaseResult;
import com.eTag.back.entity.SearchVo;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class DevicesServiceImpl implements IDevicesService {

    @Value("${file.upload-dir}")
    private String uploadDir;
    @Resource
    private DevicesMapper devicesMapper;

    @Override
    public Page<Devices> searchDevicePageHelper(SearchVo searchVo) {
        return devicesMapper.searchDevicePageHelper(searchVo);
    }

    @Override
    public String uploadFile(MultipartFile file) throws IOException {

        if (file.isEmpty()) throw new RuntimeException("文件不能为空");

        //todo 根据MD5检查重复文件

        String fileName = file.getOriginalFilename();
        Path filePath = Paths.get(uploadDir, fileName);
        Files.write(filePath, file.getBytes());
        String fileUrl = "/uploads/" + fileName;

        return fileUrl;
    }
}
