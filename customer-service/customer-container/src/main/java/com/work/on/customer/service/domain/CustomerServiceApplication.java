package com.work.on.customer.service.domain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = { "com.work.on.customer.service.dataaccess", "com.work.on.dataaccess" })
@EntityScan(basePackages = { "com.work.on.customer.service.dataaccess", "com.work.on.dataaccess"})
@SpringBootApplication(scanBasePackages = "com.work.on")
public class CustomerServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }
}
