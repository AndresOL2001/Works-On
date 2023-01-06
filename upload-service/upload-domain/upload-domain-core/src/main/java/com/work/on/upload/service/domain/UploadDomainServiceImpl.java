package com.work.on.upload.service.domain;

import com.work.on.domain.valueobject.FileId;
import com.work.on.upload.service.domain.entity.File;
import com.work.on.upload.service.domain.event.LogoCreatedEvent;
import lombok.extern.slf4j.Slf4j;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@Slf4j
public class UploadDomainServiceImpl implements UploadDomainService{
    @Override
    public LogoCreatedEvent logoCreatedEvent(File file) {
        file.initiateFile();
        file.validateIsImage(file);
        file.initiateLogo();
        log.info("Logo created event with id: {} is initiated", file.getId().getValue());
        return new LogoCreatedEvent(file, ZonedDateTime.now(ZoneId.of("UTC")));
    }

    @Override
    public LogoCreatedEvent logoUpdatedEvent(File file, FileId fileId) {
        file.setId(fileId);
        file.setCreatedAt(ZonedDateTime.now(ZoneId.of("UTC")));
        file.validateIsImage(file);
        file.initiateLogo();
        return new LogoCreatedEvent(file, file.getCreatedAt());
    }
}
