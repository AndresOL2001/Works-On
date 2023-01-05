package com.work.on.user.service.domain.entity;

import com.work.on.domain.entity.AgregateRoot;
import com.work.on.domain.valueobject.Money;
import com.work.on.domain.valueobject.UserId;
import com.work.on.user.service.domain.exception.UserDomainException;

import java.util.Random;
import java.util.UUID;
import java.util.stream.Collectors;

public class User extends AgregateRoot<UserId> {

    private final UUID customerId;

    private final String controlNumber;

    private final String name;

    private final String job;

    private final String country;

    private final String state;

    private final String zone;

    private final String address;

    private final String email;

    private Money points;

    public void setPoints(Money points) {
        this.points = points;
    }

    private String password;

    public UUID getCustomerId() {
        return customerId;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String generatePassword(){
        String password = new Random().ints(10, 33, 122).mapToObj(i -> String.valueOf((char)i)).collect(Collectors.joining());
        return password;
    }

    public void initiateUser(){
        setId(new UserId(UUID.randomUUID()));
        setPoints(Money.ZERO);
        setPassword(generatePassword());
        if(getId() == null || password == null){
            throw new UserDomainException("User is not in correct state for initialization !");
        }
    }

    public String getControlNumber() {
        return controlNumber;
    }

    public String getName() {
        return name;
    }

    public String getJob() {
        return job;
    }

    public String getCountry() {
        return country;
    }

    public String getState() {
        return state;
    }

    public String getZone() {
        return zone;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public Money getPoints() {
        return points;
    }

    public String getPassword() {
        return password;
    }

    private User(Builder builder) {
        setId(builder.id);
        customerId = builder.customerId;
        controlNumber = builder.controlNumber;
        name = builder.name;
        job = builder.job;
        country = builder.country;
        state = builder.state;
        zone = builder.zone;
        address = builder.address;
        email = builder.email;
        points = builder.points;
        password = builder.password;
    }

    public static Builder newBuilder() {
        return new Builder();
    }


    public static final class Builder {

        private UUID customerId;
        private UserId id;
        private String controlNumber;
        private String name;
        private String job;
        private String country;
        private String state;
        private String zone;
        private String address;
        private String email;
        private Money points;
        private String password;

        private Builder() {
        }

        public Builder id(UserId val) {
            id = val;
            return this;
        }

        public Builder customerId(UUID val) {
            customerId = val;
            return this;
        }


        public Builder controlNumber(String val) {
            controlNumber = val;
            return this;
        }

        public Builder name(String val) {
            name = val;
            return this;
        }

        public Builder job(String val) {
            job = val;
            return this;
        }

        public Builder country(String val) {
            country = val;
            return this;
        }

        public Builder state(String val) {
            state = val;
            return this;
        }

        public Builder zone(String val) {
            zone = val;
            return this;
        }

        public Builder address(String val) {
            address = val;
            return this;
        }

        public Builder email(String val) {
            email = val;
            return this;
        }

        public Builder points(Money val) {
            points = val;
            return this;
        }

        public Builder password(String val) {
            password = val;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}
