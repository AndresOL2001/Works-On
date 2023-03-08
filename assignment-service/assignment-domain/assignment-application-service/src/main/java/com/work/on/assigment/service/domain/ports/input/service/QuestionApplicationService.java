package com.work.on.assigment.service.domain.ports.input.service;

import com.work.on.assigment.service.domain.dto.create.CreateAssignmentCommand;
import com.work.on.assigment.service.domain.dto.create.CreateQuestionCommand;
import com.work.on.assigment.service.domain.dto.query.GetAssignmentQuery;
import com.work.on.assigment.service.domain.dto.query.GetQuestionQuery;
import com.work.on.assigment.service.domain.dto.response.CreateAssignmentResponse;
import com.work.on.assigment.service.domain.dto.response.CreateQuestionResponse;
import com.work.on.assigment.service.domain.dto.response.GetAssignmentResponse;

import javax.validation.Valid;

public interface QuestionApplicationService {
    CreateQuestionResponse createQuestion(@Valid CreateQuestionCommand createQuestionCommand);

    GetQuestionQuery trackOrder(@Valid GetQuestionQuery getQuestionQuery);
}
