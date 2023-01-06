package com.work.on.upload.service.domain.dto.create;

import com.work.on.domain.valueobject.CustomerId;
import com.work.on.domain.valueobject.FileType;
import com.work.on.domain.valueobject.SubscriptionType;
import com.work.on.domain.valueobject.TopicType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.time.ZonedDateTime;

@Getter
@Builder
@AllArgsConstructor
public class CreateLogoCommand {

    @NotNull
    private final String title;
    @NotNull
    private final String url;
    @NotNull
    private final FileType type;
    @NotNull
    private final CustomerId customerId;
}
