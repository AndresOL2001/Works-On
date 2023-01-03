package com.work.on.customer.service.domain.entity;

import com.work.on.domain.entity.BaseEntity;

public class Color extends BaseEntity<Long> {

    private final Long colorId;
    private final String hex;

    private Color(Builder builder) {
         setId(builder.id);
        colorId = builder.colorId;
        hex = builder.hex;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getHex() {
        return hex;
    }



    public static final class Builder {
        private Long id;
        private Long colorId;
        private String hex;

        private Builder() {
        }

        public Builder id(Long val) {
            id = val;
            return this;
        }

        public Builder colorId(Long val) {
            colorId = val;
            return this;
        }

        public Builder hex(String val) {
            hex = val;
            return this;
        }

        public Color build() {
            return new Color(this);
        }
    }
}
