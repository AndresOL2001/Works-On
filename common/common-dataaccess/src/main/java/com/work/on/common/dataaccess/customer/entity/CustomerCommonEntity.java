package com.work.on.common.dataaccess.customer.entity;

import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
@Table(name = "customers_view")
@Entity
public class CustomerCommonEntity {

    @Id
    private UUID customerId;

    private String name;

    public CustomerCommonEntity(UUID customerId) {
        this.customerId = customerId;
    }
}
