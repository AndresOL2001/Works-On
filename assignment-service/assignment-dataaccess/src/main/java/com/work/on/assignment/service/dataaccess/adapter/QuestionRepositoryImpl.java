package com.work.on.assignment.service.dataaccess.adapter;

import com.work.on.assigment.service.domain.ports.output.repository.QuestionRepository;
import com.work.on.assignment.service.dataaccess.entity.PollEntity;
import com.work.on.assignment.service.dataaccess.entity.QuestionEntity;
import com.work.on.assignment.service.dataaccess.mapper.AssignmentDataAccessMapper;
import com.work.on.assignment.service.dataaccess.repository.PollJpaRepository;
import com.work.on.assignment.service.dataaccess.repository.QuestionJpaRepository;
import com.work.on.assignment.service.domain.entity.Question;
import com.work.on.assignment.service.domain.exception.AssignmentDomainException;
import com.work.on.assignment.service.domain.valueobject.QuestionId;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class QuestionRepositoryImpl implements QuestionRepository {

    private final QuestionJpaRepository questionJpaRepository;

    private final AssignmentDataAccessMapper assignmentDataAccessMapper;

    private final PollJpaRepository pollJpaRepository;

    public QuestionRepositoryImpl(QuestionJpaRepository questionJpaRepository, AssignmentDataAccessMapper assignmentDataAccessMapper, PollJpaRepository pollJpaRepository) {
        this.questionJpaRepository = questionJpaRepository;
        this.assignmentDataAccessMapper = assignmentDataAccessMapper;
        this.pollJpaRepository = pollJpaRepository;
    }

    @Override
    public Optional<Question> findQuestionById(QuestionId questionId) {
        return questionJpaRepository.findById(questionId).map(assignmentDataAccessMapper::questionEntityToQuestion);
    }

    @Override
    public Question createQuestion(Question question) {
        QuestionEntity questionEntity = new QuestionEntity();
        try {
            Optional<PollEntity> pollEntity = pollJpaRepository.findById(question.getPollId().getValue());
            if(pollEntity.isPresent()){
                questionEntity = assignmentDataAccessMapper.questionToQuestionEntity(question);
                questionEntity.setPoll(pollEntity.get());
                questionJpaRepository.save(questionEntity);
                return assignmentDataAccessMapper.questionEntityToQuestion(questionEntity);

            }else{
                System.out.println("NO EXISTE NINGUNA TAREA CON ESE ID");
                return null;
            }


        }catch (Exception e){
            System.out.println(e.getMessage());
            throw  new AssignmentDomainException("Task with id: doesn't exist");
        }
    }
}
