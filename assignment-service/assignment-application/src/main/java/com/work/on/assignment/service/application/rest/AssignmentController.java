package com.work.on.assignment.service.application.rest;

import com.work.on.assigment.service.domain.dto.create.CreateAssignmentCommand;
import com.work.on.assigment.service.domain.dto.query.GetAssignmentQuery;
import com.work.on.assigment.service.domain.dto.response.CreateAssignmentResponse;
import com.work.on.assigment.service.domain.dto.response.GetAssignmentResponse;
import com.work.on.assigment.service.domain.ports.input.service.AssignmentApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(value = "/assignments", produces = "application/vnd.api.v1+json")
public class AssignmentController {

    private final AssignmentApplicationService assignmentApplicationService;

    public AssignmentController(AssignmentApplicationService assignmentApplicationService) {
        this.assignmentApplicationService = assignmentApplicationService;
    }

    @PostMapping
    public ResponseEntity<CreateAssignmentResponse> createAssignment(@RequestBody CreateAssignmentCommand
                                                                         createAssignmentCommand) {
        log.info("Creating assignment for the customerId: {}", createAssignmentCommand.getCustomerId());
        CreateAssignmentResponse response = assignmentApplicationService.createCustomer(createAssignmentCommand);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{trackingId}")
    public ResponseEntity<GetAssignmentResponse> getAssignmentById(@PathVariable GetAssignmentQuery getAssignmentQuery) {
        GetAssignmentResponse getAssignmentResponse =
                assignmentApplicationService.trackOrder(getAssignmentQuery);
        log.info("Returning assignment with assignment id: {}", getAssignmentQuery.getAssignmentId());
        return  ResponseEntity.ok(getAssignmentResponse);
    }
}
