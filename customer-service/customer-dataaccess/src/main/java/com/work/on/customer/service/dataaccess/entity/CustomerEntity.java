package com.work.on.customer.service.dataaccess.entity;

import com.work.on.customer.service.domain.entity.Color;
import com.work.on.customer.service.domain.entity.User;
import com.work.on.domain.valueobject.SubscriptionType;
import lombok.*;
import org.springframework.context.annotation.Primary;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customers")
@Entity
public class CustomerEntity {

    @Id
    private UUID customerId;

    private String name;

    private String logo;
    private ZonedDateTime createdAt;
    private ZonedDateTime subscriptionFinishAt;
    @Enumerated(EnumType.STRING)
    private SubscriptionType subscriptionType;
    private boolean active;
    @ManyToMany
    @JoinTable(
            name = "colors_customers",
            joinColumns = @JoinColumn(name = "customerId"),
            inverseJoinColumns = @JoinColumn(name = "colorId"))
    private List<ColorEntity> colors;

}
