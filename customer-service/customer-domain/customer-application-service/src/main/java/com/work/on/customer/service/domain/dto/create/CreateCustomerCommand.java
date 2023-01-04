package com.work.on.customer.service.domain.dto.create;

import com.work.on.domain.valueobject.SubscriptionType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class CreateCustomerCommand {
    @NotNull
    private final String fullName;

    @NotNull
    private final SubscriptionType subscriptionType;

    @NotNull
    private final List<ColorCreate> colorList;
}
