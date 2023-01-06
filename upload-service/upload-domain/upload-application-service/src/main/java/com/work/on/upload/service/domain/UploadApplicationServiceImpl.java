package com.work.on.upload.service.domain;

import com.work.on.domain.valueobject.CustomerId;
import com.work.on.domain.valueobject.FileType;
import com.work.on.upload.service.domain.dto.create.CreateLogoCommand;
import com.work.on.upload.service.domain.dto.create.CreateLogoResponse;
import com.work.on.upload.service.domain.event.LogoCreatedEvent;
import com.work.on.upload.service.domain.mapper.UploadDataMapper;
import com.work.on.upload.service.domain.ports.input.service.UploadApplicationService;
import com.work.on.upload.service.domain.ports.output.message.publisher.upload.LogoCreatedEventMessagePublisher;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Slf4j
@Validated
@Service
public class UploadApplicationServiceImpl implements UploadApplicationService {
    private final LogoCreatedCommandHandler logoCreatedCommandHandler;

    private final LogoCreatedVerifyTopic logoCreatedVerifyTopic;

    private final LogoCreatedEventMessagePublisher logoCreatedEventMessagePublisher;

    private final Path root = Paths.get("D:\\Programming Course\\work-on\\upload-service\\upload-domain\\upload-application-service\\src\\main\\resources\\static\\uploads\\logos");

    private final UploadDataMapper uploadDataMapper;

    public UploadApplicationServiceImpl(LogoCreatedCommandHandler logoCreatedCommandHandler, LogoCreatedVerifyTopic logoCreatedVerifyTopic, LogoCreatedEventMessagePublisher logoCreatedEventMessagePublisher, UploadDataMapper uploadDataMapper) {
        this.logoCreatedCommandHandler = logoCreatedCommandHandler;
        this.logoCreatedVerifyTopic = logoCreatedVerifyTopic;
        this.logoCreatedEventMessagePublisher = logoCreatedEventMessagePublisher;
        this.uploadDataMapper = uploadDataMapper;
    }


    @Override
    public CreateLogoResponse createLogo(CreateLogoCommand createLogoCommand) {
        com.work.on.upload.service.domain.entity.File fileDB = logoCreatedVerifyTopic.verifyTopicLogo(createLogoCommand.getCustomerId().getValue());
        if(fileDB != null){
            LogoCreatedEvent logoCreatedEvent = logoCreatedCommandHandler.updateLogo(createLogoCommand,fileDB);
            logoCreatedEventMessagePublisher.publish(logoCreatedEvent);

            return uploadDataMapper
                    .createLogoCreatedEventToCreateLogoResponse(logoCreatedEvent,"LogoCreatedEvent Updated Succesfully");
        }else{
            LogoCreatedEvent logoCreatedEvent = logoCreatedCommandHandler.createLogo(createLogoCommand);
            logoCreatedEventMessagePublisher.publish(logoCreatedEvent);

            return uploadDataMapper
                    .createLogoCreatedEventToCreateLogoResponse(logoCreatedEvent,"LogoCreatedEvent Created Succesfully");
        }

    }

    @Override
    public CreateLogoCommand saveLogo(MultipartFile file,UUID customerId) {
        String url;
        String fileName;
        String extension;
        try {
            com.work.on.upload.service.domain.entity.File fileDB = logoCreatedVerifyTopic.verifyTopicLogo(customerId);
            if(fileDB != null){
                File fileToDelete = new File(this.root.resolve(fileDB.getUrl()).toUri());
                fileToDelete.delete();
            }
            fileName = file.getOriginalFilename().replaceAll(" ", "_");
            url = customerId + "-" + "Logo-"+fileName;
            extension = FilenameUtils.getExtension(file.getOriginalFilename());
            Files.copy(file.getInputStream(), this.root.resolve(url));
        } catch (Exception e) {
            throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
        }
        return CreateLogoCommand.builder()
                .url(url)
                .customerId(new CustomerId(customerId))
                .title(fileName)
                .type(getExtensionType(extension))
                .build();
    }

    private FileType getExtensionType(String extension){
        switch (extension) {
            case "pdf", "docx", "xlsx","csv" -> {
                return FileType.DOCUMENT;
            }
            case "mp3","mp4"->{
                return FileType.VIDEO;
            }
            case "jpg","png","jpeg"-> {
                return FileType.IMAGE;
            }
        }
        return null;
    }

}
