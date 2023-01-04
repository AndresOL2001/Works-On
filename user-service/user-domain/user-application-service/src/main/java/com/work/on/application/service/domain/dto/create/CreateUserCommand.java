package com.work.on.application.service.domain.dto.create;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class CreateUserCommand {

    @NotNull
    private final UUID customerId;
    @NotNull
    private final String controlNumber;
    @NotNull
    private final String name;
    @NotNull
    private final String job;
    @NotNull
    private final String country;
    @NotNull
    private final String state;
    @NotNull
    private final String zone;
    @NotNull
    private final String address;
    @NotNull
    private final String email;


}
