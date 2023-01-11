package com.work.on.assignment.service.dataaccess.entity;

import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users_view")
public class UserEntity {
    @Id
    private UUID userId;

    @ManyToOne()
    @JoinColumn(name = "assignmentId")
    private AssignmentEntity assignment;
}
