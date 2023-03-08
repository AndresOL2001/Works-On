package com.work.on.assignment.service.domain.entity;

import com.work.on.assignment.service.domain.valueobject.PollId;
import com.work.on.assignment.service.domain.valueobject.QuestionId;
import com.work.on.assignment.service.domain.valueobject.TaskId;
import com.work.on.domain.entity.BaseEntity;

import java.util.UUID;

public class Question extends BaseEntity<QuestionId> {

    private PollId pollId;
    private String question;
    private String correctAnswer;

    public PollId getPollId() {
        return pollId;
    }

    public String getQuestion() {
        return question;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    private Question(Builder builder) {
        question = builder.question;
        correctAnswer = builder.correctAnswer;
        pollId = builder.pollId;
        setId(builder.id);
    }

    public void initiatePoll() {
        setId(new QuestionId(UUID.randomUUID()));
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static final class Builder {
        private String question;

        private PollId pollId;
        private String correctAnswer;
        private QuestionId id;

        private Builder() {
        }

        public Builder question(String val) {
            question = val;
            return this;
        }

        public Builder pollId(PollId val){
            pollId = val;
            return this;
        }

        public Builder correctAnswer(String val) {
            correctAnswer = val;
            return this;
        }

        public Builder id(QuestionId val) {
            id = val;
            return this;
        }

        public Question build() {
            return new Question(this);
        }
    }
}
