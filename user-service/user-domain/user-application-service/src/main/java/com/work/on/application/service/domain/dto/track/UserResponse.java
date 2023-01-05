package com.work.on.application.service.domain.dto.track;

import com.work.on.domain.valueobject.Money;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;
@Getter
@Builder
@Setter
@AllArgsConstructor
public class UserResponse {

    private final String customerName;

    private final String name;

    private final String job;

    private final String country;

    private final String state;

    private final String zone;

    private final String address;

    private final String email;

    private Money points;
}
