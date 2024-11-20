package com.eTag.back.api.service.impl;

import cn.hutool.core.lang.UUID;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.digest.DigestUtil;
import cn.hutool.crypto.digest.MD5;
import com.eTag.back.api.mapper.DevicesMapper;
import com.eTag.back.api.mapper.TemplateMapper;
import com.eTag.back.api.pojo.Devices;
import com.eTag.back.api.pojo.Template;
import com.eTag.back.api.service.IDevicesService;
import com.eTag.back.entity.SearchVo;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

@Service
public class DevicesServiceImpl implements IDevicesService {

    @Value("${file.upload-dir}")
    private String uploadDir;
    @Resource
    private DevicesMapper devicesMapper;
    @Resource
    private TemplateMapper templateMapper;

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

    @Override
    @Transactional
    public void addLabel(Devices devices) {
        System.out.println(devices);

        Devices isExist = devicesMapper.selectByClientId(devices.getClientId());
        //新增
        if (isExist == null) {
            Devices insert = Devices.builder().clientId(devices.getClientId()).name(devices.getName()).status(true)
                    .createTime(new Date()).createUser("admin").build();
            devicesMapper.insertSelective(insert);

            Template image = devices.getImage();

            image.setUuid(UUID.randomUUID().toString());
            image.setName(image.getUrl());
            File imageFile = new File(image.getUrl().replace("/uploads/", uploadDir + "/"));
            image.setMd5(DigestUtil.md5Hex(imageFile));
            image.setClientId(insert.getClientId());
            templateMapper.insertSelective(image);


            Template video = devices.getVideo();

            video.setUuid(UUID.randomUUID().toString());
            video.setName(image.getUrl());
            File videoFile = new File(video.getUrl().replace("/uploads/", uploadDir + "/"));
            video.setMd5(DigestUtil.md5Hex(videoFile));
            video.setClientId(insert.getClientId());
            templateMapper.insertSelective(video);

            //覆盖
        } else {

            Devices update = Devices.builder().clientId(devices.getClientId()).name(devices.getName())
                    .updateTime(new Date()).updateUser("admin").build();
            devicesMapper.updateSelective(update);

            Template image = devices.getImage();

            image.setName(image.getUrl());
            File imageFile = new File(image.getUrl().replace("/uploads/", uploadDir + "/"));
            image.setMd5(DigestUtil.md5Hex(imageFile));
            image.setClientId(update.getClientId());
            templateMapper.updateSelective(image);

            Template video = devices.getVideo();
            video.setName(video.getUrl());
            File videoFile = new File(video.getUrl().replace("/uploads/", uploadDir + "/"));
            video.setMd5(DigestUtil.md5Hex(videoFile));
            video.setClientId(update.getClientId());
            templateMapper.updateSelective(video);

        }
    }

    @Override
    @Transactional
    public void deleteDevice(Devices devices) {
        devicesMapper.deleteByClientId(devices.getClientId());
        templateMapper.deleteByClientId(devices.getClientId());
    }
}
