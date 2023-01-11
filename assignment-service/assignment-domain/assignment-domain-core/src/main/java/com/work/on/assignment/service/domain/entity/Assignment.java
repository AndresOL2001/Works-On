package com.work.on.assignment.service.domain.entity;

import com.work.on.domain.entity.AgregateRoot;
import com.work.on.domain.valueobject.AssignmentId;
import com.work.on.domain.valueobject.CustomerId;
import com.work.on.domain.valueobject.Money;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

public class Assignment extends AgregateRoot<AssignmentId> {
    private String topic;
    private CustomerId customerId;
    private String description;
    private ZonedDateTime creationDate;
    private ZonedDateTime deliveryDate;
    private Money points;
    private List<Task> tasks;

    private List<User> users;

    public void setDeliveryDate(ZonedDateTime deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public CustomerId getCustomerId() {
        return customerId;
    }

    public String getDescription() {
        return description;
    }

    public Money getPoints() {
        return points;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setCreationDate(ZonedDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public String getTopic() {
        return topic;
    }

    public ZonedDateTime getCreationDate() {
        return creationDate;
    }

    public ZonedDateTime getDeliveryDate() {
        return deliveryDate;
    }

    private Assignment(Builder builder) {
        topic = builder.topic;
        creationDate = builder.creationDate;
        deliveryDate = builder.deliveryDate;
        points = builder.points;
        tasks = builder.tasks;
        description = builder.description;
        customerId = builder.customerId;
        users = builder.users;
        setId(builder.id);
    }


    public void initiateAssignment(int deliveryDaysCount){
        setId(new AssignmentId(UUID.randomUUID()));
        creationDate = ZonedDateTime.now(ZoneId.of("UTC"));
        deliveryDate = creationDate.plusDays(deliveryDaysCount);

    }



    public static Builder newBuilder() {
        return new Builder();
    }


    public static final class Builder {
        private String topic;

        private CustomerId customerId;

        private String description;
        private ZonedDateTime creationDate;
        private ZonedDateTime deliveryDate;
        private Money points;
        private List<Task> tasks;

        private List<User> users;

        private AssignmentId id;

        private Builder() {
        }

        public Builder topic(String val) {
            topic = val;
            return this;
        }

        public Builder description(String val) {
            description = val;
            return this;
        }

        public Builder creationDate(ZonedDateTime val) {
            creationDate = val;
            return this;
        }

        public Builder deliveryDate(ZonedDateTime val) {
            deliveryDate = val;
            return this;
        }

        public Builder points(Money val) {
            points = val;
            return this;
        }

        public Builder customerId(CustomerId val) {
            customerId = val;
            return this;
        }

        public Builder users(List<User> val) {
            users = val;
            return this;
        }

        public Builder tasks(List<Task> val) {
            tasks = val;
            return this;
        }

        public Builder id(AssignmentId val) {
            id = val;
            return this;
        }

        public Assignment build() {
            return new Assignment(this);
        }
    }
}
