package com.work.on.upload.service.messaging.mapper;

import com.work.on.kafka.order.avro.model.CustomerAvroModel;
import com.work.on.kafka.order.avro.model.FileAvroModel;
import com.work.on.kafka.order.avro.model.FileType;
import com.work.on.upload.service.domain.dto.message.CustomerMessagingModel;
import com.work.on.upload.service.domain.event.LogoCreatedEvent;
import org.springframework.stereotype.Component;

@Component
public class UploadMessagingDataMapper {
    public FileAvroModel logoCreatedEventToFileAvroModel(LogoCreatedEvent logoCreatedEvent) {
        return FileAvroModel.newBuilder()
                .setId(logoCreatedEvent.getFile().getId().getValue().toString())
                .setCreatedAt(logoCreatedEvent.getCreatedAt().toInstant())
                .setCustomerId(logoCreatedEvent.getFile().getCustomerId().getValue().toString())
                .setFileType(FileType.valueOf(logoCreatedEvent.getFile().getType().name()))
                .setUrl(logoCreatedEvent.getFile().getUrl())
                .setTitle(logoCreatedEvent.getFile().getTitle())
                .build();
    }

    public CustomerMessagingModel customerAvroModeltoCustomerModel(CustomerAvroModel customerAvroModel) {
        return CustomerMessagingModel.builder()
                .customerId(customerAvroModel.getId())
                .name(customerAvroModel.getName())
                .build();
    }
}
