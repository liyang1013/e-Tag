package com.eTag.back.api.service.impl;

import cn.hutool.core.lang.UUID;
import cn.hutool.crypto.digest.DigestUtil;
import cn.hutool.json.JSONUtil;
import com.eTag.back.api.mapper.DevicesMapper;
import com.eTag.back.api.mapper.TemplateMapper;
import com.eTag.back.api.pojo.*;
import com.eTag.back.api.service.IDevicesService;
import com.eTag.back.entity.SearchVo;
import com.eTag.back.exception.ELabelException;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class DevicesServiceImpl implements IDevicesService {

    @Value("${file.upload-dir}")
    private String uploadDir;
    @Value("${file.api-path}")
    private String apiPath;
    @Resource
    private DevicesMapper devicesMapper;
    @Resource
    private TemplateMapper templateMapper;

    @Override
    public Page<Devices> searchDevicePageHelper(SearchVo searchVo) {
        User u = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return devicesMapper.searchDevicePageHelper(searchVo);
    }

    @Override
    public String uploadFile(MultipartFile file) throws IOException {

        if (file.isEmpty()) throw new RuntimeException("文件不能为空");
        //todo 根据MD5检查重复文件
        String fileName = file.getOriginalFilename();
        Path filePath = Paths.get(uploadDir, fileName);
        Files.write(filePath, file.getBytes());
        return fileName;
    }

    @Override
    @Transactional
    public void addLabel(Devices devices) {
        Devices isExist = devicesMapper.selectByClientId(devices.getClientId(), null);
        //新增
        if (isExist == null) {
            Devices insert = Devices.builder().clientId(devices.getClientId()).name(devices.getName()).status(true).createTime(new Date()).createUser("admin").build();
            devicesMapper.insertSelective(insert);

            Template image = devices.getImage();
            image.setUuid(UUID.randomUUID().toString());
            File imageFile = new File(uploadDir + image.getName());
            image.setMd5(DigestUtil.md5Hex(imageFile));
            image.setClientId(insert.getClientId());
            templateMapper.insertSelective(image);

            Template video = devices.getVideo();
            video.setUuid(UUID.randomUUID().toString());
            File videoFile = new File(uploadDir + video.getName());
            video.setMd5(DigestUtil.md5Hex(videoFile));
            video.setClientId(insert.getClientId());
            templateMapper.insertSelective(video);

            //覆盖
        } else {

            Devices update = Devices.builder().clientId(devices.getClientId()).name(devices.getName()).updateTime(new Date()).updateUser("admin").build();
            devicesMapper.updateSelective(update);

            Template image = devices.getImage();
            File imageFile = new File(uploadDir + image.getName());
            image.setMd5(DigestUtil.md5Hex(imageFile));
            image.setClientId(update.getClientId());
            templateMapper.updateSelective(image);

            Template video = devices.getVideo();
            File videoFile = new File(uploadDir + video.getName());
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

    @Override
    public List<Template> getTemplate(Devices devices) {
        return templateMapper.getTemplateByClientId(devices.getClientId());
    }

    @Override
    public void enable(Devices devices) {
        Devices update = Devices.builder().clientId(devices.getClientId()).status(devices.getStatus()).build();
        devicesMapper.updateSelective(update);
    }

    @Override
    public String getLabel(String clientid) {

        Devices devices = devicesMapper.selectByClientId(clientid, true);
        if(devices == null) throw new ELabelException("设备clientid错误或者不可用");
        List<Template> templates = templateMapper.getTemplateByClientId(clientid);

        Label label = new Label();
        label.setId(clientid);
        label.setItemCode(clientid);
        label.setItemName(clientid);
        label.setNlast(devices.getNlast());

        for (Template template : templates) {
            if (template.getType().equals("image")) {
                LabelPicture labelPicture = new LabelPicture();
                labelPicture.setX(template.getX() * 2);
                labelPicture.setY(template.getY()  * 2);
                labelPicture.setHeight(template.getHeight()  * 2);
                labelPicture.setWidth(template.getWidth()  * 2);
                labelPicture.setPictureName(template.getName());
                labelPicture.setPictureMD5(template.getMd5());
                labelPicture.setPictureUrl(apiPath + template.getName());
                label.setLabelPicture(labelPicture);
            } else if (template.getType().equals("video")) {

                LabelVideo labelVideo = new LabelVideo();
                labelVideo.setX(template.getX()  * 2);
                labelVideo.setY(template.getY()  * 2);
                labelVideo.setHeight(template.getHeight()  * 2);
                labelVideo.setWidth(template.getWidth()  * 2);

                Video video = new Video();
                video.setVideoName(template.getName());
                video.setVideoUrl(apiPath + template.getName());
                video.setVideoNo(1);
                video.setVideoMD5(template.getMd5());

                labelVideo.setVideoList(new ArrayList<>());
                labelVideo.getVideoList().add(video);

                label.setLabelVideo(labelVideo);
            }
        }

        return JSONUtil.toJsonStr(label);

    }
}
