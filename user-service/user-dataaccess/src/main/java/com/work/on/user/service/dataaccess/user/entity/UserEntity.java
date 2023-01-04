package com.work.on.user.service.dataaccess.user.entity;

import com.work.on.user.service.dataaccess.customer.entity.CustomerEntity;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
@Entity
public class UserEntity {

    @Id
    private  UUID userId;

    @ManyToOne()
    @JoinColumn(name = "customerId")
    private CustomerEntity customer;

    private  String controlNumber;

    private  String name;

    private  String job;

    private  String country;

    private  String state;

    private  String zone;

    private  String address;

    private  String email;

    private BigDecimal points;

    private String password;

}
