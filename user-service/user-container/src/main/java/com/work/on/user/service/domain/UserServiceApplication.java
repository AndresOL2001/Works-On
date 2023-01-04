package com.work.on.user.service.domain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = { "com.work.on.user.service.dataaccess", "com.work.on.dataaccess" })
@EntityScan(basePackages = { "com.work.on.user.service.dataaccess", "com.work.on.dataaccess"})
@SpringBootApplication(scanBasePackages = "com.work.on")
public class UserServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);
    }

}
