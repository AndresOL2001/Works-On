package com.work.on.customer.service.domain.entity;

import com.work.on.domain.entity.BaseEntity;
import com.work.on.domain.valueobject.UserId;

public class User extends BaseEntity<UserId> {

    private final String name;

    private User(Builder builder) {
        setId(builder.id);
        name = builder.name;
    }

    public static Builder newBuilder() {
        return new Builder();
    }


    public static final class Builder {
        private UserId id;
        private String name;

        private Builder() {
        }

        public Builder id(UserId val) {
            id = val;
            return this;
        }

        public Builder name(String val) {
            name = val;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}
