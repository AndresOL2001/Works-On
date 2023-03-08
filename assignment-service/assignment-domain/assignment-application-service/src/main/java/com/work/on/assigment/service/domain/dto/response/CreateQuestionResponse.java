package com.work.on.assigment.service.domain.dto.response;

import com.work.on.assignment.service.domain.entity.Question;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
@Builder
@AllArgsConstructor
public class CreateQuestionResponse {
    @NotNull
    private final String message;
    private final Question question;
}
