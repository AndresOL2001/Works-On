package com.work.on.customer.service.messaging.mapper;

import com.work.on.customer.service.domain.dto.message.LogoMessagingModel;
import com.work.on.domain.valueobject.CustomerId;
import com.work.on.domain.valueobject.FileId;
import com.work.on.kafka.order.avro.model.Color;
import com.work.on.kafka.order.avro.model.CustomerAvroModel;
import com.work.on.kafka.order.avro.model.FileAvroModel;
import com.work.on.kafka.order.avro.model.SubscriptionType;
import com.work.on.customer.service.domain.event.CustomerCreatedEvent;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class CustomerMessagingDataMapper {

    public CustomerAvroModel customerCreatedEventToCustomerAvroModel(CustomerCreatedEvent customerCreatedEvent) {
        return CustomerAvroModel.newBuilder()
                .setId(customerCreatedEvent.getCustomer().getId().getValue().toString())
                .setActive(customerCreatedEvent.getCustomer().isActive())
                .setName(customerCreatedEvent.getCustomer().getName())
                .setColors(customerCreatedEvent.getCustomer().getColorList().stream().map(avroModel ->
                        Color.newBuilder()
                                .setHex(avroModel.getHex())
                                .build())
                        .collect(Collectors.toList()))
                .setCreatedAt(customerCreatedEvent.getCreatedAt().toInstant())
                .setSubscriptionFinishAt(customerCreatedEvent.getCustomer().getSubscriptionFinishAt().toInstant())
                .setSubscriptionType(SubscriptionType.valueOf(customerCreatedEvent.getCustomer().getSubscriptionType().name()))
                .build();
    }

    public LogoMessagingModel FileAvroModeltoLogoMessagingModel(FileAvroModel fileAvroModel) {
        return LogoMessagingModel.builder()
                .customerId(new CustomerId(UUID.fromString(fileAvroModel.getCustomerId())))
                .fileId(new FileId(UUID.fromString(fileAvroModel.getId())))
                .url(fileAvroModel.getUrl())
                .build();
    }
}
