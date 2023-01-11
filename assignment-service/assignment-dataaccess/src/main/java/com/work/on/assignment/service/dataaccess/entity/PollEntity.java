package com.work.on.assignment.service.dataaccess.entity;

import com.work.on.assignment.service.domain.entity.Question;
import com.work.on.assignment.service.domain.valueobject.TaskId;
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
@Table(name = "polls")
public class PollEntity {
    @Id
    private UUID pollId;
    @ManyToOne()
    @JoinColumn(name = "taskId")
    private TaskEntity task;

    private String pollName;

    @OneToMany(mappedBy = "poll", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<QuestionEntity> questionList;
}
