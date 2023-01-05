package com.work.on.application.service.domain.dto.track;

import com.work.on.domain.valueobject.Money;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder
@Setter
@AllArgsConstructor
public class UsersResponse {

    private final String customerId;

    private final String name;

    private final String job;

    private final String country;

    private final String state;

    private final String zone;

    private final String address;

    private final String email;

    private Money points;
}
