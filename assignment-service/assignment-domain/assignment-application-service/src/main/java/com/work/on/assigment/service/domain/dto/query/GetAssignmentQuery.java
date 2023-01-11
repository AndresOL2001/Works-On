package com.work.on.assigment.service.domain.dto.query;

import com.work.on.domain.valueobject.AssignmentId;
import com.work.on.domain.valueobject.CustomerId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
@Builder
@AllArgsConstructor
public class GetAssignmentQuery {
    @NotNull
    private final AssignmentId assignmentId;
}
