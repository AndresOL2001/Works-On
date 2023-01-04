package com.work.on.application.service.domain.ports.output.message.publisher.user;

import com.work.on.user.service.domain.event.UserCreatedEvent;

public interface UserMessagePublisher {

    void publish(UserCreatedEvent userCreatedEvent);

}
