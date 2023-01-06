package com.work.on.customer.service.domain.dto.message;

import com.work.on.domain.valueobject.CustomerId;
import com.work.on.domain.valueobject.FileId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class LogoMessagingModel {
    private FileId fileId;
    private CustomerId customerId;
    private String url;
}
