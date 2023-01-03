package com.work.on.customer.service.domain.dto.create;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class CreateCustomerResponse {

    private final UUID customerId;
    @NotNull
    private final String message;

}
