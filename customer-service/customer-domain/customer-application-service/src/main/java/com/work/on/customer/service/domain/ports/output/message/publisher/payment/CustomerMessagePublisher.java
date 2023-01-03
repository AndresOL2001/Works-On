package com.work.on.customer.service.domain.ports.output.message.publisher.payment;


import com.work.on.customer.service.domain.event.CustomerCreatedEvent;


public interface CustomerMessagePublisher {

    void publish(CustomerCreatedEvent customerCreatedEvent);
}
