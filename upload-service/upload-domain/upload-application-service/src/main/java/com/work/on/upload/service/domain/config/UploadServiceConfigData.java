package com.work.on.upload.service.domain.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "upload-service")
public class UploadServiceConfigData {
    private String logoRequestTopicName;

}
