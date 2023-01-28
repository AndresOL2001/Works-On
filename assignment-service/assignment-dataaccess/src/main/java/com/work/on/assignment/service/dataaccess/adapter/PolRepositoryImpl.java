package com.work.on.assignment.service.dataaccess.adapter;

import com.work.on.assigment.service.domain.ports.output.repository.PolRepository;
import com.work.on.assigment.service.domain.ports.output.repository.TaskRepository;
import com.work.on.assignment.service.dataaccess.entity.PollEntity;
import com.work.on.assignment.service.dataaccess.entity.TaskEntity;
import com.work.on.assignment.service.dataaccess.mapper.AssignmentDataAccessMapper;
import com.work.on.assignment.service.dataaccess.repository.PollJpaRepository;
import com.work.on.assignment.service.dataaccess.repository.TaskJpaRepository;
import com.work.on.assignment.service.domain.entity.Poll;
import com.work.on.assignment.service.domain.entity.Task;
import com.work.on.assignment.service.domain.exception.AssignmentDomainException;
import com.work.on.assignment.service.domain.valueobject.PollId;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PolRepositoryImpl implements PolRepository {

    private final PollJpaRepository polRepository;

    private final TaskJpaRepository taskRepository;
    private final AssignmentDataAccessMapper assignmentDataAccessMapper;

    public PolRepositoryImpl(PollJpaRepository polRepository, TaskJpaRepository taskRepository, AssignmentDataAccessMapper assignmentDataAccessMapper) {
        this.polRepository = polRepository;
        this.taskRepository = taskRepository;
        this.assignmentDataAccessMapper = assignmentDataAccessMapper;
    }

    @Override
    public Poll createPoll(Poll poll) {
        PollEntity pollEntity = new PollEntity();
        try {
            Optional<TaskEntity> taskEntity = taskRepository.findById(poll.getTaskId().getValue());
            if(taskEntity.isPresent()){
                pollEntity = assignmentDataAccessMapper.polToPolEntity(poll);
                pollEntity.setTask(taskEntity.get());
                polRepository.save(pollEntity);
                return assignmentDataAccessMapper.polEntityToPol(pollEntity);

            }else{
                System.out.println("NO EXISTE NINGUNA TAREA CON ESE ID");
                return null;
            }


        }catch (Exception e){
            System.out.println(e.getMessage());
            throw  new AssignmentDomainException("Task with id:doesn't exist");
        }

    }

    @Override
    public Optional<Poll> findPollById(PollId pollId) {
        return polRepository.findById(pollId.getValue()).map(assignmentDataAccessMapper::polEntityToPol);
    }
}
