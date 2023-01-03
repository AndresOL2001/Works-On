package com.work.on.customer.service.domain.dto.create;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Builder
@AllArgsConstructor
public class ColorCreate {
    @NotNull
    private final Long colorId;
    @NotNull
    private final String hex;

}
