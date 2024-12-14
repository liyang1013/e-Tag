package com.eTag.back.timer;

import com.eTag.back.api.mapper.TemplateMapper;
import com.eTag.back.api.pojo.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.List;

@Component
public class ScheduledTasks {

    @Autowired
    private TemplateMapper templateMapper;

    @Value("${file.upload-dir}")
    private String uploadDir;

    @Scheduled(fixedRate = 86400000)
    public void reportCurrentTime() {
        List<Template> list = templateMapper.getFileList();
        list.forEach(e -> System.out.println(uploadDir + e.getName()));
    }
}