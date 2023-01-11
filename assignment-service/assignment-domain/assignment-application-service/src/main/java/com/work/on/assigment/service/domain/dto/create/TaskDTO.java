package com.work.on.assigment.service.domain.dto.create;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class TaskDTO {

    private int index;

    private String taskName;

    private String taskDescription;
}
