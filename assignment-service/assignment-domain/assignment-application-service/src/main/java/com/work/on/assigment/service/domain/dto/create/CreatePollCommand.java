package com.work.on.assigment.service.domain.dto.create;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class CreatePollCommand {

    private String name;

    private UUID taskId;
}
