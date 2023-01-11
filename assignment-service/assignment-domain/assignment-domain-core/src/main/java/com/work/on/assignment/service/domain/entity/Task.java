package com.work.on.assignment.service.domain.entity;

import com.work.on.assignment.service.domain.valueobject.TaskId;
import com.work.on.domain.entity.BaseEntity;
import com.work.on.domain.valueobject.AssignmentId;

import java.util.List;
import java.util.UUID;

public class Task extends BaseEntity<TaskId> {

    private String taskName;

    private String taskDescription;

    private AssignmentId assignmentId;

    private List<Poll> taskPolls;

    private List<File> files;

    public String getTaskName() {
        return taskName;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public AssignmentId getAssignmentId() {
        return assignmentId;
    }

    public List<Poll> getTaskPolls() {
        return taskPolls;
    }

    public List<File> getFiles() {
        return files;
    }

    private Task(Builder builder) {
        taskName = builder.taskName;
        taskDescription = builder.taskDescription;
        assignmentId = builder.assignmentId;
        taskPolls = builder.taskPolls;
        setId(builder.id);
    }

    public static Builder newBuilder() {
        return new Builder();
    }


    public void initializeTask(AssignmentId id, Task task) {
        setId(new TaskId(UUID.randomUUID()));
        assignmentId = id;
        taskDescription = task.getTaskDescription();
        taskName = task.getTaskName();
    }


    public static final class Builder {
        private String taskName;
        private String taskDescription;
        private AssignmentId assignmentId;
        private List<Poll> taskPolls;

        private List<File> files;
        private TaskId id;

        private Builder() {
        }

        public Builder taskName(String val) {
            taskName = val;
            return this;
        }

        public Builder taskDescription(String val) {
            taskDescription = val;
            return this;
        }

        public Builder assignmentId(AssignmentId val) {
            assignmentId = val;
            return this;
        }

        public Builder taskPolls(List<Poll> val) {
            taskPolls = val;
            return this;
        }

        public Builder files(List<File> val) {
            files = val;
            return this;
        }

        public Builder id(TaskId val) {
            id = val;
            return this;
        }

        public Task build() {
            return new Task(this);
        }
    }
}
