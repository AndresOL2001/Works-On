package com.work.on.upload.service.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {
    @Bean
    public UploadDomainService customerDomainService() {
        return new UploadDomainServiceImpl();
    }
}
