package com.work.on.assigment.service.domain.dto.query;

import com.work.on.assignment.service.domain.valueobject.PollId;
import com.work.on.assignment.service.domain.valueobject.QuestionId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
@Builder
@AllArgsConstructor
public class GetQuestionQuery {
    @NotNull
    private final QuestionId questionId;
}
