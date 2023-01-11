package com.work.on.assignment.service.dataaccess.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customer_view")
public class CustomerEntity {

    @Id
    UUID customerId;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AssignmentEntity> assignmentList;

}
