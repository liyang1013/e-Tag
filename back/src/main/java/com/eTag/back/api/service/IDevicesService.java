package com.eTag.back.api.service;

import com.eTag.back.api.pojo.Devices;
import com.eTag.back.api.pojo.LabelRequestBody;
import com.eTag.back.api.pojo.Template;
import com.eTag.back.entity.SearchVo;
import com.github.pagehelper.Page;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public interface IDevicesService {
    Page<Devices> searchDevicePageHelper(SearchVo searchVo);

    String uploadFile(MultipartFile file) throws IOException, NoSuchAlgorithmException;

    void addLabel(Devices devices);

    void deleteDevice(Devices devices);

    List<Template> getTemplate(Devices devices);

    void enable(Devices devices);

    String getLabel(LabelRequestBody body);

    String postLabel(LabelRequestBody body);
}
