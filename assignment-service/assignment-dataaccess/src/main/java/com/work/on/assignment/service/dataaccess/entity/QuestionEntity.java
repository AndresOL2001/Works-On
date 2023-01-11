package com.work.on.assignment.service.dataaccess.entity;

import com.work.on.assignment.service.domain.valueobject.PollId;
import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "questions")
public class QuestionEntity {

    @Id
    private UUID questionId;

    @ManyToOne()
    @JoinColumn(name = "pollId")
    private PollEntity poll;

    private String question;

    private String correctAnswer;

}
