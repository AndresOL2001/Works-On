package com.work.on.upload.service.domain.ports.output.message.publisher.upload;

import com.work.on.upload.service.domain.event.LogoCreatedEvent;

public interface LogoCreatedEventMessagePublisher {

    void publish(LogoCreatedEvent logoCreatedEvent);

}
