package com.work.on.user.service.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {
    @Bean
    public UserDomainService customerDomainService() {
        return new UserDomainServiceImpl();
    }
}
