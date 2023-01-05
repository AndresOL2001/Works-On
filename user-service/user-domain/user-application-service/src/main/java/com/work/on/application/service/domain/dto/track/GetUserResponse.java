package com.work.on.application.service.domain.dto.track;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class GetUserResponse {

    private UserResponse user;

    private String message;

    private  List<String> failureMessages;

    public GetUserResponse(UserResponse user, String message) {
        this.user = user;
        this.message = message;
    }
}
