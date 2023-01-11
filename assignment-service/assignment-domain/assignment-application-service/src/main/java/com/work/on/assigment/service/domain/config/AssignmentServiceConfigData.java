package com.work.on.assigment.service.domain.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "user-service")
public class AssignmentServiceConfigData {
    private String assignmentRequestTopicName;

}
