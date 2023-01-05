package com.work.on.application.service.domain.dto.track;

import com.work.on.user.service.domain.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class GetUsersResponse {
    private List<UsersResponse> user;

    private String message;

    private List<String> failureMessages;

    public GetUsersResponse(List<UsersResponse> user, String message) {
        this.user = user;
        this.message = message;
    }
}
