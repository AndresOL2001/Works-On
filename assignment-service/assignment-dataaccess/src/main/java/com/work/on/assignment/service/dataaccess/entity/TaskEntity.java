package com.work.on.assignment.service.dataaccess.entity;

import com.work.on.assignment.service.domain.entity.Assignment;
import com.work.on.assignment.service.domain.entity.File;
import com.work.on.assignment.service.domain.entity.Poll;
import com.work.on.domain.valueobject.AssignmentId;
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
@Table(name = "tasks")
public class TaskEntity {

    @Id
    private UUID taskId;

    private String taskName;

    private String taskDescription;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "assignmentId")
    private AssignmentEntity assignment;

    @OneToMany(mappedBy = "task", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PollEntity> taskPolls;

    @OneToMany(mappedBy = "task", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FileEntity> files;
}
