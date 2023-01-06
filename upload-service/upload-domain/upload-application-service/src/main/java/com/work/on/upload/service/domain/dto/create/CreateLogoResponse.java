package com.work.on.upload.service.domain.dto.create;

import com.work.on.upload.service.domain.entity.File;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class CreateLogoResponse {
    @NotNull
    private final UUID fileId;
    @NotNull
    private final String message;

}
