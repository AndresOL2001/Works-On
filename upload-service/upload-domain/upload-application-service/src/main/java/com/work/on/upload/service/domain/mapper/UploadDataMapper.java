package com.work.on.upload.service.domain.mapper;

import com.work.on.domain.valueobject.CustomerId;
import com.work.on.upload.service.domain.dto.create.CreateLogoCommand;
import com.work.on.upload.service.domain.dto.create.CreateLogoResponse;
import com.work.on.upload.service.domain.dto.message.CustomerMessagingModel;
import com.work.on.upload.service.domain.entity.Customer;
import com.work.on.upload.service.domain.entity.File;
import com.work.on.upload.service.domain.event.LogoCreatedEvent;
import org.springframework.stereotype.Component;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.UUID;

@Component
public class UploadDataMapper {
    public File createLogoCommandToFile(CreateLogoCommand createLogoCommand) {
        return File.newBuilder()
                .customerId(createLogoCommand.getCustomerId())
                .title(createLogoCommand.getTitle())
                .type(createLogoCommand.getType())
                .url(createLogoCommand.getUrl())
                .build();
    }


    public CreateLogoResponse createLogoCreatedEventToCreateLogoResponse(LogoCreatedEvent logoCreatedEvent,String message) {
        return CreateLogoResponse.builder()
                .fileId(logoCreatedEvent.getFile().getId().getValue())
                .message(message)
                .build();
    }

    public Customer customerModelToCustomer(CustomerMessagingModel customerModel) {
        return Customer.newBuilder()
                .name(customerModel.getName())
                .id(new CustomerId(UUID.fromString(customerModel.getCustomerId())))
                .build();
    }
}
