package com.work.on.user.service.messaging.mapper;

import com.work.on.application.service.domain.dto.message.CustomerModel;
import com.work.on.domain.valueobject.CustomerId;
import com.work.on.kafka.order.avro.model.CustomerAvroModel;
import org.springframework.stereotype.Component;

@Component
public class UserMesagingDataMapper {
    public CustomerModel customerAvroModeltoCustomerModel(CustomerAvroModel customerAvroModel) {
        return CustomerModel.builder()
                .customerId(customerAvroModel.getId())
                .name(customerAvroModel.getName())
                .build();
    }
}
