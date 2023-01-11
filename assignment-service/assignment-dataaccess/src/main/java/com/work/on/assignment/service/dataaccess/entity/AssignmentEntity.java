package com.work.on.assignment.service.dataaccess.entity;

import com.work.on.assignment.service.domain.entity.Task;
import com.work.on.assignment.service.domain.entity.User;
import com.work.on.domain.valueobject.Money;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "assignments")
public class AssignmentEntity {

    @Id
    private UUID assignmentId;

    private String topic;

    private String description;
    private ZonedDateTime creationDate;
    private ZonedDateTime deliveryDate;
    private BigDecimal points;

    @OneToMany(mappedBy = "assignment", cascade = CascadeType.ALL)
    private List<TaskEntity> tasks;

    @OneToMany(mappedBy = "assignment", cascade = CascadeType.ALL)
    private List<UserEntity> users;

    @ManyToOne()
    @JoinColumn(name = "customerId")
    private CustomerEntity customer;

}
