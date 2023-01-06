package com.work.on.upload.service.domain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = { "com.work.on.upload.service.dataaccess", "com.work.on.dataaccess" })
@EntityScan(basePackages = { "com.work.on.upload.service.dataaccess", "com.work.on.dataaccess"})
@SpringBootApplication(scanBasePackages = "com.work.on")
public class UploadServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UploadServiceApplication.class, args);
    }

}
