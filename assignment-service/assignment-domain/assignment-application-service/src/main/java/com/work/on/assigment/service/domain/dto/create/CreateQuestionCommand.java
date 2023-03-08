package com.work.on.assigment.service.domain.dto.create;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class CreateQuestionCommand {

    private UUID pollId;

    private String question;

    private String answer;
}
