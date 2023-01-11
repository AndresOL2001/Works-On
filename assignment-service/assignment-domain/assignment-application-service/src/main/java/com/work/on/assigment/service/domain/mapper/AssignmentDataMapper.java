package com.work.on.assigment.service.domain.mapper;

import com.work.on.assigment.service.domain.dto.create.CreateAssignmentCommand;
import com.work.on.assigment.service.domain.dto.response.CreateAssignmentResponse;
import com.work.on.assigment.service.domain.dto.response.GetAssignmentResponse;
import com.work.on.assignment.service.domain.entity.Assignment;
import com.work.on.assignment.service.domain.entity.Customer;
import com.work.on.assignment.service.domain.entity.Task;
import com.work.on.assignment.service.domain.entity.User;
import com.work.on.assignment.service.domain.valueobject.TaskId;
import com.work.on.domain.valueobject.CustomerId;
import com.work.on.domain.valueobject.UserId;
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

}
