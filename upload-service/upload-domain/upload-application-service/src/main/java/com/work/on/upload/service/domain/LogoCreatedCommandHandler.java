package com.work.on.upload.service.domain;

import com.work.on.domain.valueobject.FileId;
import com.work.on.upload.service.domain.dto.create.CreateLogoCommand;
import com.work.on.upload.service.domain.entity.File;
import com.work.on.upload.service.domain.event.LogoCreatedEvent;
import com.work.on.upload.service.domain.exception.UploadDomainException;
import com.work.on.upload.service.domain.mapper.UploadDataMapper;
import com.work.on.upload.service.domain.ports.output.repository.UploadRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Component
public class LogoCreatedCommandHandler {

    private final UploadDomainService uploadDomainService;

    private final UploadRepository uploadRepository;

    private final UploadDataMapper uploadDataMapper;


    public LogoCreatedCommandHandler(UploadDomainService uploadDomainService, UploadRepository uploadRepository, UploadDataMapper uploadDataMapper) {
        this.uploadDomainService = uploadDomainService;
        this.uploadRepository = uploadRepository;
        this.uploadDataMapper = uploadDataMapper;
    }

    @Transactional
    public LogoCreatedEvent createLogo(CreateLogoCommand createLogoCommand) {

        File file = uploadDataMapper.createLogoCommandToFile(createLogoCommand);
        LogoCreatedEvent logoCreatedEvent = uploadDomainService.logoCreatedEvent(file);
        File fileSaved = uploadRepository.saveFile(file);
        if (fileSaved == null) {
            log.error("Could not save file (Logo) with customer id: {}", createLogoCommand.getCustomerId().getValue());
            throw new UploadDomainException("Could not save file (Logo) with customer id: {} " +
                    createLogoCommand.getCustomerId().getValue());
        }
        log.info("Returning logoCreatedEvent with id: {}", logoCreatedEvent.getFile().getId().getValue().toString());
        return logoCreatedEvent;
    }

    @Transactional
    public LogoCreatedEvent updateLogo(CreateLogoCommand createLogoCommand,File file) {
        File fileCreateLogoCommand = uploadDataMapper.createLogoCommandToFile(createLogoCommand);
        LogoCreatedEvent logoCreatedEvent = uploadDomainService.logoUpdatedEvent(fileCreateLogoCommand,file.getId());
        File fileSaved = uploadRepository.saveFile(fileCreateLogoCommand);
        if (fileSaved == null) {
            log.error("Could not save file (Logo) with customer id: {}", file.getCustomerId().getValue());
            throw new UploadDomainException("Could not save file (Logo) with customer id: {} " +
                    file.getCustomerId().getValue());
        }
        log.info("Returning logoCreated with id: {}", logoCreatedEvent.getFile().getId().getValue().toString());
        return logoCreatedEvent;
    }

}
