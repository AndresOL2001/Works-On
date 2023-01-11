package com.work.on.assigment.service.domain.ports.input.service;

import com.work.on.assigment.service.domain.dto.create.CreateAssignmentCommand;
import com.work.on.assigment.service.domain.dto.query.GetAssignmentQuery;
import com.work.on.assigment.service.domain.dto.response.CreateAssignmentResponse;
import com.work.on.assigment.service.domain.dto.response.GetAssignmentResponse;

import javax.validation.Valid;
import java.util.UUID;

public interface AssignmentApplicationService {

    CreateAssignmentResponse createCustomer(@Valid CreateAssignmentCommand createAssignmentCommand);

    GetAssignmentResponse trackOrder(@Valid GetAssignmentQuery assignmentId);

}
