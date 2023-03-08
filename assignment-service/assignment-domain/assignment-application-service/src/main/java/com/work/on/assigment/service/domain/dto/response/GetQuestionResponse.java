package com.work.on.assigment.service.domain.dto.response;

import com.work.on.assignment.service.domain.entity.Question;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class GetQuestionResponse {

    @NotNull
    private final Question question;

    private final List<String> failureMessages;
}
