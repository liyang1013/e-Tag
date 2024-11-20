package com.eTag.back.api.mapper;

import com.eTag.back.api.pojo.Template;
import org.springframework.stereotype.Repository;

@Repository
public interface TemplateMapper {

    int insertSelective(Template record);

    void updateSelective(Template video);

    void deleteByClientId(String clientId);
}