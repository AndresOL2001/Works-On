package com.work.on.application.service.domain.ports.input.message.listener.user;

import com.work.on.application.service.domain.dto.message.CustomerMessagingModel;

public interface CustomerCreatedMessageListener {
    void customerCreated(CustomerMessagingModel customerModel);
}
