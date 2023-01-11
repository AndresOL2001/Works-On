package com.work.on.assignment.service.domain;

import com.work.on.customer.service.domain.CustomerDomainService;
import com.work.on.customer.service.domain.CustomerDomainServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public AssignmentDomainService assignmentDomainService() {
        return new AssignmentDomainServiceImpl();
    }
}
