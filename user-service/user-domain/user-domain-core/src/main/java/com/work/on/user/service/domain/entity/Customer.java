package com.work.on.user.service.domain.entity;

import com.work.on.domain.entity.BaseEntity;
import com.work.on.domain.valueobject.CustomerId;

import java.util.UUID;

public class Customer extends BaseEntity<CustomerId> {
    private String name;

    public Customer() {
    }

    public Customer(Builder builder) {
        setId(builder.id);
        name = builder.name;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getName() {
        return name;
    }

    public static final class Builder {
        private CustomerId id;
        private String name;

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

        public Customer build() {
            return new Customer(this);
        }
    }
}
