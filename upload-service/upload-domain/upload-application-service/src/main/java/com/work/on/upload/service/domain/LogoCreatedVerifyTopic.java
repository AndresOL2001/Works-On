package com.work.on.upload.service.domain;

import com.work.on.domain.valueobject.CustomerId;
import com.work.on.domain.valueobject.TopicType;
import com.work.on.upload.service.domain.dto.create.CreateLogoCommand;
import com.work.on.upload.service.domain.entity.File;
import com.work.on.upload.service.domain.event.LogoCreatedEvent;
import com.work.on.upload.service.domain.exception.UploadDomainException;
import com.work.on.upload.service.domain.mapper.UploadDataMapper;
import com.work.on.upload.service.domain.ports.output.repository.UploadRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.nio.file.Files;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
public class LogoCreatedVerifyTopic {
    private final UploadDomainService uploadDomainService;

    private final UploadRepository uploadRepository;

    private final UploadDataMapper uploadDataMapper;

    public LogoCreatedVerifyTopic(UploadDomainService uploadDomainService, UploadRepository uploadRepository, UploadDataMapper uploadDataMapper) {
        this.uploadDomainService = uploadDomainService;
        this.uploadRepository = uploadRepository;
        this.uploadDataMapper = uploadDataMapper;
    }

    public File verifyTopicLogo(UUID customerId) {

        Optional<List<File>> filesOptional = uploadRepository.getFilesByCustomerId(new CustomerId(customerId));

        if(filesOptional.isEmpty()){
            return null;
        }

        for (File file:filesOptional.get()) {
            if(file.getTopic().name().equals(TopicType.LOGO.name())){
                return file;
            }
        }
        return null;
    }
}
