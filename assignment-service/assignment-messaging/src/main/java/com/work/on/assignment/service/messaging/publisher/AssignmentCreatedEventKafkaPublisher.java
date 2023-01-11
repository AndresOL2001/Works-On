package com.work.on.assignment.service.messaging.publisher;

import com.work.on.assigment.service.domain.config.AssignmentServiceConfigData;
import com.work.on.assigment.service.domain.ports.output.publisher.AssignmentMessagePublisher;
import com.work.on.assignment.service.domain.event.AssignmentCreatedEvent;
import com.work.on.assignment.service.messaging.mapper.AssignmentMessagingDataMapper;
import com.work.on.kafka.order.avro.model.AssignmentAvroModel;
import com.work.on.kafka.producer.service.KafkaProducer;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Slf4j
@Component
public class AssignmentCreatedEventKafkaPublisher implements AssignmentMessagePublisher {

    private final AssignmentMessagingDataMapper assignmentMessagingDataMapper;

    private final KafkaProducer<String, AssignmentAvroModel> kafkaProducer;

    private final AssignmentServiceConfigData assignmentServiceConfigData;

    public AssignmentCreatedEventKafkaPublisher( AssignmentMessagingDataMapper assignmentMessagingDataMapper, KafkaProducer<String, AssignmentAvroModel> kafkaProducer, AssignmentServiceConfigData assignmentServiceConfigData) {
        this.assignmentMessagingDataMapper = assignmentMessagingDataMapper;
        this.kafkaProducer = kafkaProducer;
        this.assignmentServiceConfigData = assignmentServiceConfigData;
    }


    @Override
    public void publish(AssignmentCreatedEvent assignmentCreatedEvent) {
        log.info("Received AssignmentCreatedEvent for assignment id: {}",
                assignmentCreatedEvent.getAssignment().getId().getValue());
        try {
            AssignmentAvroModel assignmentAvroModel = assignmentMessagingDataMapper
                    .assignmentCreatedEventToAssignmentAvroModel(assignmentCreatedEvent);

            kafkaProducer.send(assignmentServiceConfigData.getAssignmentRequestTopicName(), assignmentAvroModel.getId(),
                    assignmentAvroModel,
                    getCallback(assignmentServiceConfigData.getAssignmentRequestTopicName(), assignmentAvroModel));

            log.info("CustomerCreatedEvent sent to kafka for customer id: {}",
                    assignmentAvroModel.getId());
        } catch (Exception e) {
            log.error("Error while sending CustomerCreatedEvent to kafka for customer id: {}," +
                    " error: {}", assignmentCreatedEvent.getAssignment().getId().getValue(), e.getMessage());
        }
    }

    private ListenableFutureCallback<SendResult<String, AssignmentAvroModel>>
    getCallback(String topicName, AssignmentAvroModel message) {
        return new ListenableFutureCallback<>() {
            @Override
            public void onFailure(Throwable throwable) {
                log.error("Error while sending message {} to topic {}", message.toString(), topicName, throwable);
            }

            @Override
            public void onSuccess(SendResult<String, AssignmentAvroModel> result) {
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
