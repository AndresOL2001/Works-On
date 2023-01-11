package com.work.on.customer.service.messaging.listener.kafka;

import com.work.on.customer.service.domain.ports.input.message.listener.logo.LogoCreatedMessageListener;
import com.work.on.customer.service.messaging.mapper.CustomerMessagingDataMapper;
import com.work.on.kafka.consumer.KafkaConsumer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class LogoCreatedEventKafkaListener implements KafkaConsumer<FileAvroModel> {

    private final LogoCreatedMessageListener logoCreatedMessageListener;
    private final CustomerMessagingDataMapper customerMessagingDataMapper;

    public LogoCreatedEventKafkaListener(LogoCreatedMessageListener logoCreatedMessageListener, CustomerMessagingDataMapper customerMessagingDataMapper) {
        this.logoCreatedMessageListener = logoCreatedMessageListener;
        this.customerMessagingDataMapper = customerMessagingDataMapper;
    }

    @Override
    @KafkaListener(id = "${kafka-consumer-config.logo-consumer-group-id}", topics = "${customer-service.logo-request-topic-name}")
    public void receive(List<FileAvroModel> messages, List<String> keys, List<Integer> partitions, List<Long> offsets) {
        log.info("{} number of files logos create messages received with keys {}, partitions {} and offsets {}",
                messages.size(),
                keys.toString(),
                partitions.toString(),
                offsets.toString());

        messages.forEach(fileAvroModel ->
                logoCreatedMessageListener.updateCustomerLogo(customerMessagingDataMapper
                        .FileAvroModeltoLogoMessagingModel(fileAvroModel)));
    }
}
