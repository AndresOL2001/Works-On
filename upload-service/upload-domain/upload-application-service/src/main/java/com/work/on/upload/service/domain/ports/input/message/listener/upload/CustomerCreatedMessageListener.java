package com.work.on.upload.service.domain.ports.input.message.listener.upload;

import com.work.on.upload.service.domain.dto.message.CustomerMessagingModel;

public interface CustomerCreatedMessageListener {

    void customerCreated(CustomerMessagingModel customerModel);

}
