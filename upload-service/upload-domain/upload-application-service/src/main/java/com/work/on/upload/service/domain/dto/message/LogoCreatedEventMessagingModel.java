package com.work.on.upload.service.domain.dto.message;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class LogoCreatedEventMessagingModel {

    private final String id;

    private final String url;

}
