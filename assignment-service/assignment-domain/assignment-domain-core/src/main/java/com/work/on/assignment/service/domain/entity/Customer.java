package com.work.on.assignment.service.domain.entity;

import com.work.on.domain.entity.CustomerCommonEntity;
import com.work.on.domain.valueobject.CustomerId;

public class Customer extends CustomerCommonEntity {


    public Customer(CustomerId id, String name) {
        super(id, name);
    }
}
