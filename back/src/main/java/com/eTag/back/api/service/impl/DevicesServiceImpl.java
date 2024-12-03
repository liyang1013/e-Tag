package com.eTag.back.api.service.impl;

import cn.hutool.core.lang.UUID;
import cn.hutool.crypto.digest.DigestUtil;
import cn.hutool.json.JSONUtil;
import com.eTag.back.api.mapper.DevicesMapper;
import com.eTag.back.api.mapper.TemplateMapper;
import com.eTag.back.api.mapper.UserMapper;
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
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
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

    @Resource
    private UserMapper userMapper;

    @Override
    public Page<Devices> searchDevicePageHelper(SearchVo searchVo) {
        User u = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(! "admin".equals(u.getRole())) searchVo.setUid(u.getUid());
        return devicesMapper.searchDevicePageHelper(searchVo);
    }

    @Override
    public String uploadFile(MultipartFile file) throws IOException, NoSuchAlgorithmException {

        if (file.isEmpty()) throw new RuntimeException("文件不能为空");

        long maxSizeForImages = 2 * 1024 * 1024; // 2MB
        long maxSizeForVideos = 25 * 1024 * 1024; // 25MB
        long fileSize = file.getSize();
        String fileName = file.getOriginalFilename();
        String fileExtension = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();

        if (Arrays.asList("jpg", "jpeg", "png", "gif").contains(fileExtension)) {
            if (fileSize > maxSizeForImages) {
                throw new RuntimeException("图片文件不能超过2MB");
            }

            // 检查图片分辨率
            BufferedImage image = ImageIO.read(new ByteArrayInputStream(file.getBytes()));
            int width = image.getWidth();
            int height = image.getHeight();

            boolean isValidResolution = (width == 800 && (height == 640 || height == 1280)) ||
                    (height == 800 && (width == 640 || width == 1280));

            if (!isValidResolution) {
                throw new RuntimeException("图片分辨率必须是800x640或者800x1280");
            }
        } else if (Arrays.asList("mp4", "avi", "mov", "mkv").contains(fileExtension)) {
            if (fileSize > maxSizeForVideos) {
                throw new RuntimeException("视频文件不能超过25MB");
            }
        } else {
            throw new RuntimeException("不支持的文件类型");
        }

        // 计算文件的MD5值
        String md5 = getFileMD5(file.getInputStream());

        // 构建存储路径
        Path uploadDirPath = Paths.get(uploadDir);
        if (!Files.exists(uploadDirPath)) {
            Files.createDirectories(uploadDirPath);
        }

        // 查找是否存在相同MD5值的文件
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(uploadDirPath, "*.*")) {
            for (Path entry : stream) {
                String existingFileName = entry.getFileName().toString();
                String existingExtension = existingFileName.substring(existingFileName.lastIndexOf(".") + 1).toLowerCase();
                if (existingExtension.equals(fileExtension)) {
                    String existingMD5 = getFileMD5(Files.newInputStream(entry));
                    if (md5.equals(existingMD5)) {
                        // MD5值相同，直接返回文件名
                        return existingFileName;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 生成唯一文件名
        String uuid = UUID.randomUUID().toString();
        String newFileName = uuid + "." + fileExtension;

        Path filePath = Paths.get(uploadDirPath.toString(), newFileName);
        Files.write(filePath, file.getBytes());
        return newFileName;
    }

    @Override
    @Transactional
    public void addLabel(Devices devices) {
        User u = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Devices isExist = devicesMapper.selectByClientId(devices.getClientId(), null);
        //新增
        if (isExist == null) {
            Devices insert = Devices.builder().clientId(devices.getClientId()).name(devices.getName()).status(true).createTime(new Date()).createUser(u.getUid()).build();
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

            Devices update = Devices.builder().clientId(devices.getClientId()).name(devices.getName()).updateTime(new Date()).updateUser(u.getUid()).build();
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
        return templateMapper.getTemplateByClientId(null,devices.getClientId(),null);
    }

    @Override
    public void enable(Devices devices) {
        Devices update = Devices.builder().clientId(devices.getClientId()).status(devices.getStatus()).build();
        devicesMapper.updateSelective(update);
    }

    @Override
    public String getLabel(LabelRequestBody body) {

        String appSecret = userMapper.selectAppSecretByAppid(body.getAppid());
        if( !DigestUtil.md5Hex( body.getStringSignTemp() + appSecret).toUpperCase().equals(body.getSign()))
            throw new ELabelException("获取失败, 签名验证失败");

        Devices devices = devicesMapper.selectByClientId(body.getClientid(), true);
        if(devices == null) throw new ELabelException("设备clientid错误或者不可用");
        List<Template> templates = templateMapper.getTemplateByClientId(body.getAppid(), body.getClientid(),true);
        if(templates.size() == 0) throw new ELabelException("设备模板数据获取失败");

        Label label = new Label();
        label.setId(body.getClientid());
        label.setItemCode(body.getClientid());
        label.setItemName(body.getClientid());
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

        devicesMapper.updateDeviceLastTime(body.getClientid());
        return JSONUtil.toJsonStr(label);

    }

    private String getFileMD5(InputStream inputStream) throws IOException, NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] buffer = new byte[1024];
        int bytesRead;
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            md.update(buffer, 0, bytesRead);
        }
        byte[] digest = md.digest();
        StringBuilder sb = new StringBuilder();
        for (byte b : digest) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}
