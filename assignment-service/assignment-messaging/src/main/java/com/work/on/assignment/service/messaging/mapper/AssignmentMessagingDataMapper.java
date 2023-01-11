package com.work.on.assignment.service.messaging.mapper;

import com.work.on.assignment.service.domain.entity.File;
import com.work.on.assignment.service.domain.entity.Poll;
import com.work.on.assignment.service.domain.entity.Task;
import com.work.on.assignment.service.domain.event.AssignmentCreatedEvent;
import com.work.on.kafka.order.avro.model.*;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AssignmentMessagingDataMapper {
    public AssignmentAvroModel assignmentCreatedEventToAssignmentAvroModel(AssignmentCreatedEvent assignmentCreatedEvent) {


        return AssignmentAvroModel.newBuilder()
                .setCreatedAt(assignmentCreatedEvent.getAssignment().getCreationDate().toInstant())
                .setId(assignmentCreatedEvent.getAssignment().getId().getValue().toString())
                .setCustomerId(assignmentCreatedEvent.getAssignment().getCustomerId().getValue().toString())
                .setDeliveryDate(assignmentCreatedEvent.getAssignment().getDeliveryDate().toInstant())
                .setPoints(assignmentCreatedEvent.getAssignment().getPoints().getAmount())
                .setTasks(assignmentCreatedEvent.getAssignment().getTasks().stream().map(task ->
                                    TaskAvroModel.newBuilder()
                                            .setName(task.getTaskName())
                                            .setDescription(task.getTaskDescription())
                                            .setId(task.getId().getValue().toString())
                                            .setPolls(listPollsToListPollAvroModel(task.getTaskPolls()))
                                            .setFiles(listFilesToFilesAvroModel(task.getFiles()))
                                            .build()
                                ).collect(Collectors.toList()))
                .build();
    }

    private List<FileAssignmentAvroModel> listFilesToFilesAvroModel(List<File> files) {
        return files.stream().map(file ->
                        FileAssignmentAvroModel.newBuilder()
                                .setId(file.getId().getValue().toString())
                                .build()
                ).collect(Collectors.toList());
    }


    private List<PollAvroModel> listPollsToListPollAvroModel(List<Poll> polls){
        return polls.stream().map(poll ->
                PollAvroModel.newBuilder()
                        .setPollName(poll.getPollDesc())
                        .setId(poll.getId().getValue().toString())
                        .setQuestions(poll.getQuestionList().stream().map(question ->
                                QuestionAvroModel.newBuilder()
                                        .setQuestionDesc(question.getQuestion())
                                        .setId(question.getId().getValue().toString())
                                        .setAnswer(question.getCorrectAnswer())
                                        .build()
                        ).collect(Collectors.toList()))
                        .build()
        ).collect(Collectors.toList());
    }
}
