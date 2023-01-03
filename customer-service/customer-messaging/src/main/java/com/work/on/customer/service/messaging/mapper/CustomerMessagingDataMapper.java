package com.work.on.customer.service.messaging.mapper;

import com.work.on.kafka.order.avro.model.Color;
import com.work.on.kafka.order.avro.model.CustomerAvroModel;
import com.work.on.kafka.order.avro.model.SubscriptionType;
import com.work.on.customer.service.domain.event.CustomerCreatedEvent;
import org.springframework.stereotype.Component;

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

}
