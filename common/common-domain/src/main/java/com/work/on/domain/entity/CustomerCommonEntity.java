package com.work.on.domain.entity;

import com.work.on.domain.valueobject.CustomerId;

public class CustomerCommonEntity extends BaseEntity<CustomerId> {
    protected String name;

    private CustomerCommonEntity(CustomerId customerId) {
        setId(customerId);
    }
    private CustomerCommonEntity(Builder builder) {
        setId(builder.id);
        name = builder.name;
    }

    protected CustomerCommonEntity(CustomerId customerId, String name) {
         setId(customerId);
        this.name= name;
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

        public CustomerCommonEntity build() {
            return new CustomerCommonEntity(this);
        }
    }
}
