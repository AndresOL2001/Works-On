package com.work.on.user.service.messaging.listener.kafka;

import com.work.on.application.service.domain.ports.input.message.listener.user.CustomerCreatedMessageListener;
import com.work.on.kafka.consumer.KafkaConsumer;
import com.work.on.kafka.order.avro.model.CustomerAvroModel;
import com.work.on.user.service.messaging.mapper.UserMesagingDataMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class CustomerCreatedEventKafkaListener implements KafkaConsumer<CustomerAvroModel> {

    private final CustomerCreatedMessageListener  customerMessageListener;
    private final UserMesagingDataMapper userMesagingDataMapper;


    public CustomerCreatedEventKafkaListener(CustomerCreatedMessageListener customerMessageListener, UserMesagingDataMapper userMesagingDataMapper) {
        this.customerMessageListener = customerMessageListener;
        this.userMesagingDataMapper = userMesagingDataMapper;
    }

    @Override
    @KafkaListener(id = "${kafka-consumer-config.customer-group-id}", topics = "${user-service.customer-request-topic-name}")
    public void receive(List<CustomerAvroModel> messages, List<String> keys, List<Integer> partitions, List<Long> offsets) {
        log.info("{} number of customer create messages received with keys {}, partitions {} and offsets {}",
                messages.size(),
                keys.toString(),
                partitions.toString(),
                offsets.toString());

        messages.forEach(customerAvroModel ->
                customerMessageListener.customerCreated(userMesagingDataMapper
                        .customerAvroModeltoCustomerModel(customerAvroModel)));
    }
}
