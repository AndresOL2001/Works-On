package com.work.on.assigment.service.domain.mapper;

import com.work.on.assigment.service.domain.dto.create.CreateAssignmentCommand;
import com.work.on.assigment.service.domain.dto.create.CreatePollCommand;
import com.work.on.assigment.service.domain.dto.create.CreateQuestionCommand;
import com.work.on.assigment.service.domain.dto.response.CreateAssignmentResponse;
import com.work.on.assigment.service.domain.dto.response.CreatePollResponse;
import com.work.on.assigment.service.domain.dto.response.CreateQuestionResponse;
import com.work.on.assigment.service.domain.dto.response.GetAssignmentResponse;
import com.work.on.assignment.service.domain.entity.*;
import com.work.on.assignment.service.domain.event.PollCreatedEvent;
import com.work.on.assignment.service.domain.event.QuestionCreatedEvent;
import com.work.on.assignment.service.domain.valueobject.PollId;
import com.work.on.assignment.service.domain.valueobject.TaskId;
import com.work.on.domain.valueobject.CustomerId;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AssignmentDataMapper {
    public Assignment createAssignmentCommandToAssignment(CreateAssignmentCommand createAssignmentCommand) {
        return Assignment.newBuilder()
                .description(createAssignmentCommand.getDescription())
                .topic(createAssignmentCommand.getTopic())
                .points(createAssignmentCommand.getPoints())
                .customerId(new CustomerId(createAssignmentCommand.getCustomerId()))
                .tasks(createAssignmentCommand.getTasks().stream().map(taskDTO ->
                        Task.newBuilder()
                                .taskName(taskDTO.getTaskName())
                                .taskDescription(taskDTO.getTaskDescription())
                                .build()
                        ).collect(Collectors.toList()))
                .build();
    }

    public GetAssignmentResponse assignmentToGetAssignmentResponse(Assignment assignment, List<String> messages) {
        return new GetAssignmentResponse(assignment,messages);
    }

    public CreateAssignmentResponse assignmentToCreateAssignmentResponse(Assignment assignment, String s) {
        return CreateAssignmentResponse.builder()
                .assignmentId(assignment.getId())
                .message(s)
                .build();
    }

    public Poll createPollCommandToPoll(CreatePollCommand createPollCommand) {
        return Poll.newBuilder()
                .taskId(new TaskId(createPollCommand.getTaskId()))
                .pollName(createPollCommand.getName())
                .build();
    }

    public Question createQuestionCommandToQuestion(CreateQuestionCommand createQuestionCommand) {
        return Question.newBuilder()
                .pollId(new PollId(createQuestionCommand.getPollId()))
                .correctAnswer(createQuestionCommand.getAnswer())
                .question(createQuestionCommand.getQuestion())
                .build();
    }

    public CreatePollResponse pollCreatedEventToCreatePollResponse(PollCreatedEvent pollCreatedEvent, String s) {
        return CreatePollResponse.builder()
                .message(s)
                .build();
    }

    public CreateQuestionResponse questionCreatedEventToQuestionResponse(QuestionCreatedEvent questionCreatedEvent,String s) {
        return CreateQuestionResponse.builder()
                .question(questionCreatedEvent.getQuestion())
                .message(s)
                .build();
    }
}
