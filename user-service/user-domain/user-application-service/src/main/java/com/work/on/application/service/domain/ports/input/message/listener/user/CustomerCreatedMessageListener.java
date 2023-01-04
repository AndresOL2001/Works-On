package com.work.on.application.service.domain.ports.input.message.listener.user;

import com.work.on.application.service.domain.dto.message.CustomerModel;

public interface CustomerCreatedMessageListener {
    void customerCreated(CustomerModel customerModel);
}
