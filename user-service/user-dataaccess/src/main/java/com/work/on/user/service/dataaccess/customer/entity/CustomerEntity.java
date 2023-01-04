package com.work.on.user.service.dataaccess.customer.entity;

import com.work.on.user.service.dataaccess.user.entity.UserEntity;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customers_users")
@Entity
public class CustomerEntity {

    @Id
    private UUID customerId;

    private String name;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UserEntity> userList;

    public CustomerEntity(UUID customerId) {
        this.customerId = customerId;
    }
}
