package com.work.on.assignment.service.dataaccess.adapter;

import com.work.on.assigment.service.domain.ports.output.repository.TaskRepository;
import com.work.on.assignment.service.dataaccess.mapper.AssignmentDataAccessMapper;
import com.work.on.assignment.service.dataaccess.repository.TaskJpaRepository;
import com.work.on.assignment.service.domain.entity.Task;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TaskRepositoryImpl implements TaskRepository{

    private final TaskJpaRepository taskJpaRepository;

    public TaskRepositoryImpl(TaskJpaRepository taskJpaRepository, AssignmentDataAccessMapper assignmentDataAccessMapper) {
        this.taskJpaRepository = taskJpaRepository;
        this.assignmentDataAccessMapper = assignmentDataAccessMapper;
    }

    private final AssignmentDataAccessMapper assignmentDataAccessMapper;

    @Override
    public List<Task> createTasks(List<Task> tasks) {
        return assignmentDataAccessMapper.taskEntitiesToTasks(
                        taskJpaRepository.saveAll(assignmentDataAccessMapper.tasksToTasksEntities(tasks)));
    }
}
