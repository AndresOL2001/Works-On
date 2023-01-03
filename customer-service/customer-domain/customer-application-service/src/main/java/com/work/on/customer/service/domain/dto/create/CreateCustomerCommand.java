package com.work.on.customer.service.domain.dto.create;

import com.work.on.customer.service.domain.entity.Color;
import com.work.on.customer.service.domain.entity.User;
import com.work.on.domain.valueobject.SubscriptionType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

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
