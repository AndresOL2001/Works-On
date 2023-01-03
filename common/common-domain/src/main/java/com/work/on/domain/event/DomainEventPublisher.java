package com.work.on.domain.event;

public interface DomainEventPublisher <T extends DomainEvent>{
    void publish(T domainEvent);
}
