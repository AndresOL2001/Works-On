package com.work.on.assigment.service.domain.dto.response;

import com.work.on.assignment.service.domain.entity.Assignment;
import com.work.on.assignment.service.domain.entity.Poll;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.util.List;
@Getter
@Builder
@AllArgsConstructor
public class GetPollResponse {

    @NotNull
    private final Poll poll;

    private final List<String> failureMessages;
}
