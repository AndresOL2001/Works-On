package com.work.on.application.service.domain.dto.message;

import com.work.on.domain.valueobject.SubscriptionType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.ZonedDateTime;

@Getter
@Builder
@AllArgsConstructor
public class CustomerMessagingModel {
    private String customerId;

    private String name;

    private String logo;
    private ZonedDateTime createdAt;
    private ZonedDateTime subscriptionFinishAt;
    private SubscriptionType subscriptionType;
    private boolean active;
}
