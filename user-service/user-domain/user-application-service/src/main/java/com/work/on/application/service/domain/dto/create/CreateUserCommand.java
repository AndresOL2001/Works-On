package com.work.on.application.service.domain.dto.create;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Builder
@Setter
@AllArgsConstructor
public class CreateUserCommand {

    @NotNull
    private  UUID customerId;
    @NotNull
    private  String controlNumber;
    @NotNull
    private  String name;
    @NotNull
    private  String job;
    @NotNull
    private  String country;
    @NotNull
    private  String state;
    @NotNull
    private  String zone;
    @NotNull
    private  String address;
    @NotNull
    private  String email;

    public CreateUserCommand() {

    }
}
