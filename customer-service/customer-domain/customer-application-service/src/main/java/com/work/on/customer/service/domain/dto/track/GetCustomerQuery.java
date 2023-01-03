package com.work.on.customer.service.domain.dto.track;

import com.work.on.domain.valueobject.CustomerId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class GetCustomerQuery {
    @NotNull
    private final CustomerId customerId;
}
