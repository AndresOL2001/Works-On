package com.work.on.assigment.service.domain.dto.response;

import com.work.on.domain.valueobject.AssignmentId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
@Builder
@AllArgsConstructor
public class CreatePollResponse {

    @NotNull
    private final String message;
}
