package com.work.on.upload.service.messaging.publisher.kafka;

import com.work.on.kafka.order.avro.model.FileAvroModel;
import com.work.on.kafka.producer.service.KafkaProducer;
import com.work.on.upload.service.domain.config.UploadServiceConfigData;
import com.work.on.upload.service.domain.event.LogoCreatedEvent;
import com.work.on.upload.service.domain.ports.output.message.publisher.upload.LogoCreatedEventMessagePublisher;
import com.work.on.upload.service.messaging.mapper.UploadMessagingDataMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Slf4j
@Component
public class LogoCreatedEventKafkaPublisher implements LogoCreatedEventMessagePublisher {

    private final UploadMessagingDataMapper uploadMessagingDataMapper;

    private final KafkaProducer<String, FileAvroModel> kafkaProducer;

    private final UploadServiceConfigData uploadServiceConfigData;

    public LogoCreatedEventKafkaPublisher(UploadMessagingDataMapper uploadMessagingDataMapper, KafkaProducer<String, FileAvroModel> kafkaProducer, UploadServiceConfigData uploadServiceConfigData) {
        this.uploadMessagingDataMapper = uploadMessagingDataMapper;
        this.kafkaProducer = kafkaProducer;
        this.uploadServiceConfigData = uploadServiceConfigData;
    }

    @Override
    public void publish(LogoCreatedEvent logoCreatedEvent) {
        log.info("Received LogoCreatedEvent for customer id: {}",
                logoCreatedEvent.getFile().getCustomerId().getValue());
        try {
            FileAvroModel fileAvroModel = uploadMessagingDataMapper
                    .logoCreatedEventToFileAvroModel(logoCreatedEvent);

            kafkaProducer.send(uploadServiceConfigData.getLogoRequestTopicName(), fileAvroModel.getId(),
                    fileAvroModel,
                    getCallback(uploadServiceConfigData.getLogoRequestTopicName(), fileAvroModel));

            log.info("LogoCreatedEvent sent to kafka for customer id: {}",
                    fileAvroModel.getId());
        } catch (Exception e) {
            log.error("Error while sending LogoCreatedEvent to kafka for customer id: {}," +
                    " error: {}", logoCreatedEvent.getFile().getId().getValue(), e.getMessage());
        }
    }

    private ListenableFutureCallback<SendResult<String, FileAvroModel>>
    getCallback(String topicName, FileAvroModel message) {
        return new ListenableFutureCallback<>() {
            @Override
            public void onFailure(Throwable throwable) {
                log.error("Error while sending message {} to topic {}", message.toString(), topicName, throwable);
            }

            @Override
            public void onSuccess(SendResult<String, FileAvroModel> result) {
                RecordMetadata metadata = result.getRecordMetadata();
                log.info("Received new metadata. Topic: {}; Partition {}; Offset {}; Timestamp {}, at time {}",
                        metadata.topic(),
                        metadata.partition(),
                        metadata.offset(),
                        metadata.timestamp(),
                        System.nanoTime());
            }
        };
    }
}
