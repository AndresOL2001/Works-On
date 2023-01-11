package com.work.on.assignment.service.domain.entity;

import com.work.on.assignment.service.domain.valueobject.TaskId;
import com.work.on.domain.entity.BaseEntity;
import com.work.on.domain.valueobject.AssignmentId;
import com.work.on.domain.valueobject.FileId;

public class File extends BaseEntity<FileId> {
    private TaskId taskId;

    private File(Builder builder) {
        taskId = builder.task;
        setId(builder.id);
    }

    public File(TaskId taskId) {
        this.taskId = taskId;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public void initiateFileTask(TaskId id) {
        taskId = id;
    }

    public static final class Builder {
        private AssignmentId assignmentId;
        private TaskId task;
        private FileId id;

        private Builder() {
        }

        public Builder assignmentId(AssignmentId val) {
            assignmentId = val;
            return this;
        }

        public Builder task(TaskId val) {
            task = val;
            return this;
        }

        public Builder id(FileId val) {
            id = val;
            return this;
        }

        public File build() {
            return new File(this);
        }
    }
}
