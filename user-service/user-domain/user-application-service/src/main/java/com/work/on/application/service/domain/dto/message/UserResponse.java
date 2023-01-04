package com.work.on.application.service.domain.dto.message;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.Instant;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class UserResponse {
    private String id;
    private Instant createdAt;
    private List<String> failureMessages;
}
