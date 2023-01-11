package com.work.on.assigment.service.domain.dto.create;

import com.work.on.domain.valueobject.CustomerId;
import com.work.on.domain.valueobject.Money;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class CreateAssignmentCommand {

    @NotNull
    private final String topic;

    @NotNull
    private final UUID customerId;

    private String description;

    private int deliveryDays;

    private Money points;

    List<TaskDTO> tasks;

    List<UserDTO> users;

}
