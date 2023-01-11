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
@Table(name = "files_view")
public class FileEntity {

    @Id
    private UUID fileId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "taskId")
    TaskEntity task;
}
