package com.work.on.upload.service.messaging.listener.kafka;

import com.work.on.kafka.consumer.KafkaConsumer;
import com.work.on.kafka.order.avro.model.CustomerAvroModel;
import com.work.on.upload.service.domain.ports.input.message.listener.upload.CustomerCreatedMessageListener;
import com.work.on.upload.service.messaging.mapper.UploadMessagingDataMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class CustomerCreatedEventKafkaListener implements KafkaConsumer<CustomerAvroModel> {
    private final CustomerCreatedMessageListener customerMessageListener;
    private final UploadMessagingDataMapper uploadMessagingDataMapper;


    public CustomerCreatedEventKafkaListener(CustomerCreatedMessageListener customerMessageListener, UploadMessagingDataMapper uploadMessagingDataMapper) {
        this.customerMessageListener = customerMessageListener;
        this.uploadMessagingDataMapper = uploadMessagingDataMapper;
    }

    @Override
    @KafkaListener(id = "${kafka-consumer-config.customer-group-id}", topics = "${upload-service.customer-request-topic-name}")
    public void receive(List<CustomerAvroModel> messages, List<String> keys, List<Integer> partitions, List<Long> offsets) {
        log.info("{} number of customer create messages received with keys {}, partitions {} and offsets {}",
                messages.size(),
                keys.toString(),
                partitions.toString(),
                offsets.toString());

        messages.forEach(customerAvroModel ->
                customerMessageListener.customerCreated(uploadMessagingDataMapper
                        .customerAvroModeltoCustomerModel(customerAvroModel)));
    }
}
