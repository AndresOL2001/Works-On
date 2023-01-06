package com.work.on.user.service.messaging.mapper;

import com.work.on.application.service.domain.dto.message.CustomerMessagingModel;
import com.work.on.kafka.order.avro.model.CustomerAvroModel;
import org.springframework.stereotype.Component;

@Component
public class UserMesagingDataMapper {
    public CustomerMessagingModel customerAvroModeltoCustomerModel(CustomerAvroModel customerAvroModel) {
        return CustomerMessagingModel.builder()
                .customerId(customerAvroModel.getId())
                .name(customerAvroModel.getName())
                .build();
    }
}
