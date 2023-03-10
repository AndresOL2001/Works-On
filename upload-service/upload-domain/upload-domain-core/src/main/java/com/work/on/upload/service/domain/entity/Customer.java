package com.work.on.upload.service.domain.entity;

import com.work.on.domain.entity.BaseEntity;
import com.work.on.domain.valueobject.CustomerId;

public class Customer extends BaseEntity<CustomerId> {
    private final String name;

    public Customer(Builder builder) {
        setId(builder.id);
        name = builder.name;
    }

    public String getName() {
        return name;
    }

    public static Builder newBuilder() {
        return new Builder();
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
