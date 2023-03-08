package com.work.on.assignment.service.application.rest;

import com.work.on.assigment.service.domain.dto.create.CreateAssignmentCommand;
import com.work.on.assigment.service.domain.dto.create.CreatePollCommand;
import com.work.on.assigment.service.domain.dto.create.CreateQuestionCommand;
import com.work.on.assigment.service.domain.dto.query.GetAssignmentQuery;
import com.work.on.assigment.service.domain.dto.response.CreateAssignmentResponse;
import com.work.on.assigment.service.domain.dto.response.CreatePollResponse;
import com.work.on.assigment.service.domain.dto.response.CreateQuestionResponse;
import com.work.on.assigment.service.domain.dto.response.GetAssignmentResponse;
import com.work.on.assigment.service.domain.ports.input.service.AssignmentApplicationService;
import com.work.on.assigment.service.domain.ports.input.service.IPollApplicationService;
import com.work.on.assigment.service.domain.ports.input.service.QuestionApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(value = "/assignments", produces = "application/vnd.api.v1+json")
public class AssignmentController {

    private final AssignmentApplicationService assignmentApplicationService;

    private final IPollApplicationService pollApplicationService;

    private final QuestionApplicationService questionApplicationService;

    public AssignmentController(AssignmentApplicationService assignmentApplicationService, IPollApplicationService pollApplicationService, QuestionApplicationService questionApplicationService) {
        this.assignmentApplicationService = assignmentApplicationService;
        this.pollApplicationService = pollApplicationService;
        this.questionApplicationService = questionApplicationService;
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

    @PostMapping("/Poll")
    public ResponseEntity<CreatePollResponse> createPoll(@RequestBody CreatePollCommand
                                                                             createPollCommand) {
        log.info("Creating poll for the taskId: {}", createPollCommand.getTaskId());
        CreatePollResponse response = pollApplicationService.createPoll(createPollCommand);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/Question")
    public ResponseEntity<CreateQuestionResponse> createQuestion(@RequestBody CreateQuestionCommand
                                                                 createQuestionCommand) {
        log.info("Creating question for poll with id: {}", createQuestionCommand.getPollId());
        CreateQuestionResponse response = questionApplicationService.createQuestion(createQuestionCommand);
        return ResponseEntity.ok(response);
    }
}
