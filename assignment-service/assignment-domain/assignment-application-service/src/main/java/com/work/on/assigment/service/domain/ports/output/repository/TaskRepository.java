package com.work.on.assigment.service.domain.ports.output.repository;

import com.work.on.assignment.service.domain.entity.Task;

import java.util.List;

public interface TaskRepository {

    List<Task> createTasks(List<Task> task);

}
