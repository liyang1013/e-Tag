package com.eTag.back.api.mapper;

import com.eTag.back.api.pojo.Template;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TemplateMapper {

    int insertSelective(Template record);

    void updateSelective(Template video);

    void deleteByClientId(String clientId);

    List<Template> getTemplateByClientId(@Param("appid") String appid, @Param("clientId") String clientId,@Param("status") Boolean status);
}