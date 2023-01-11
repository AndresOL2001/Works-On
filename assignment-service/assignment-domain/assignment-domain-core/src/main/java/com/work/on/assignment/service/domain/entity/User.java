package com.work.on.assignment.service.domain.entity;

import com.work.on.domain.entity.BaseEntity;
import com.work.on.domain.valueobject.AssignmentId;
import com.work.on.domain.valueobject.UserId;

public class User extends BaseEntity<UserId> {

    private AssignmentId assignmentId;

    private User(Builder builder) {
        assignmentId = builder.assignmentId;
        setId(builder.id);
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static final class Builder {
        private AssignmentId assignmentId;
        private UserId id;

        private Builder() {
        }

        public Builder assignmentId(AssignmentId val) {
            assignmentId = val;
            return this;
        }

        public Builder id(UserId val) {
            id = val;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}
