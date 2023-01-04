package com.work.on.application.service.domain.dto.create;

import com.work.on.user.service.domain.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
@Builder
@AllArgsConstructor
public class CreateUserResponse {
    @NotNull
    private final String message;
}
