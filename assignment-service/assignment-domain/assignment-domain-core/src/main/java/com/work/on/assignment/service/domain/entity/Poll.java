package com.work.on.assignment.service.domain.entity;

import com.work.on.assignment.service.domain.valueobject.PollId;
import com.work.on.assignment.service.domain.valueobject.TaskId;
import com.work.on.domain.entity.BaseEntity;

import java.util.List;
import java.util.UUID;

public class Poll extends BaseEntity<PollId> {
    public TaskId getTaskId() {
        return taskId;
    }

    public List<Question> getQuestionList() {
        return questionList;
    }

    private TaskId taskId;

    private List<Question> questionList;

    private String pollDesc;

    private Poll(Builder builder) {
        pollDesc = builder.pollName;
        taskId = builder.taskId;
        setId(builder.id);
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public void initiatePoll(TaskId id) {
        setId(new PollId(UUID.randomUUID()));
        taskId = id;
    }

    public String getPollDesc() {
        return pollDesc;
    }

    public static final class Builder {
        private List<Question> questionList;
        private PollId id;

        private TaskId taskId;

        private String pollName;

        private Builder() {
        }

        public Builder questionList(List<Question> val) {
            questionList = val;
            return this;
        }

        public Builder id(PollId val) {
            id = val;
            return this;
        }

        public Builder pollName(String val) {
            pollName = val;
            return this;
        }

        public Builder taskId(TaskId val) {
            taskId = val;
            return this;
        }

        public Poll build() {
            return new Poll(this);
        }
    }
}
