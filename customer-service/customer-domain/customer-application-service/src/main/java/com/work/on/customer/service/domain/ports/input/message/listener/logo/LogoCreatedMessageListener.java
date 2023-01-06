package com.work.on.customer.service.domain.ports.input.message.listener.logo;

import com.work.on.customer.service.domain.dto.message.LogoMessagingModel;

public interface LogoCreatedMessageListener {
    void updateCustomerLogo(LogoMessagingModel customerModel);

}
