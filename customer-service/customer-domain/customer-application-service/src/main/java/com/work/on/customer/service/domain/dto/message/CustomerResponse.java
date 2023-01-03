package com.work.on.customer.service.domain.dto.message;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.Instant;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class CustomerResponse {
    private String id;
    private String customerId;
    private Instant createdAt;
    private List<String> failureMessages;
}
