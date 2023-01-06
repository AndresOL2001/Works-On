package com.work.on.customer.service.domain.entity;

import com.work.on.customer.service.domain.exception.CustomerDomainException;
import com.work.on.domain.entity.AgregateRoot;
import com.work.on.domain.valueobject.CustomerId;
import com.work.on.domain.valueobject.SubscriptionType;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

public class Customer extends AgregateRoot<CustomerId> {
    private final String name;
    private final List<Color> colorList;
    private  String logo;
    private ZonedDateTime createdAt;
    private  ZonedDateTime subscriptionFinishAt;
    private final SubscriptionType subscriptionType;
    private boolean active;
    private List<String> failureMessages;

    private Customer(Builder builder) {
        setId(builder.id);
        name = builder.name;
        colorList = builder.colorList;
        logo = builder.logo;
        createdAt = builder.createdAt;
        subscriptionFinishAt = builder.subscriptionFinishAt;
        subscriptionType = builder.subscriptionType;
        active = builder.active;
        failureMessages = builder.failureMessages;
    }

    public static Builder builder() {
        return new Builder();
    }

    public List<String> getFailureMessages() {
        return failureMessages;
    }


   public void initiateCustomer(){
        setId(new CustomerId(UUID.randomUUID()));
        createdAt = ZonedDateTime.now(ZoneId.of("UTC"));
        if(subscriptionType == null || getId() == null){
            throw new CustomerDomainException("Customer is not in correct state for initialization (Subscription type doesnt choosed)!");
        }
    }

    public void validateSubscriptionFinishAt(Customer customer){
        switch (customer.subscriptionType){
            case BASIC, STANDARD -> subscriptionFinishAt = ZonedDateTime.now(ZoneId.of("UTC")).plusDays(30);
            case PREMIUM -> subscriptionFinishAt = ZonedDateTime.now(ZoneId.of("UTC")).plusDays(45);
        }
    }

    public void setSubscriptionFinishAt(ZonedDateTime subscriptionFinishAt) {
        this.subscriptionFinishAt = subscriptionFinishAt;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getName() {
        return name;
    }

    public List<Color> getColorList() {
        return colorList;
    }

    public String getLogo() {
        return logo;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    public ZonedDateTime getSubscriptionFinishAt() {
        return subscriptionFinishAt;
    }

    public SubscriptionType getSubscriptionType() {
        return subscriptionType;
    }

    public boolean isActive() {
        return active;
    }


    public static final class Builder {
        private CustomerId id;
        private String name;
        private List<Color> colorList;
        private String logo;
        private ZonedDateTime createdAt;
        private ZonedDateTime subscriptionFinishAt;
        private SubscriptionType subscriptionType;
        private boolean active;
        private List<String> failureMessages;

        private Builder() {
        }

        public Builder id(CustomerId val) {
            id = val;
            return this;
        }

        public Builder name(String val) {
            name = val;
            return this;
        }

        public Builder colorList(List<Color> val) {
            colorList = val;
            return this;
        }

        public Builder logo(String val) {
            logo = val;
            return this;
        }

        public Builder createdAt(ZonedDateTime val) {
            createdAt = val;
            return this;
        }

        public Builder subscriptionFinishAt(ZonedDateTime val) {
            subscriptionFinishAt = val;
            return this;
        }

        public Builder subscriptionType(SubscriptionType val) {
            subscriptionType = val;
            return this;
        }

        public Builder active(boolean val) {
            active = val;
            return this;
        }

        public Builder failureMessages(List<String> val) {
            failureMessages = val;
            return this;
        }

        public Customer build() {
            return new Customer(this);
        }
    }
}
