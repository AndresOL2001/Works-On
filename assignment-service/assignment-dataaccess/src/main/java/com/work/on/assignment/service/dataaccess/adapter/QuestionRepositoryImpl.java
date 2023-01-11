package com.work.on.assignment.service.dataaccess.adapter;

import com.work.on.assigment.service.domain.ports.output.repository.QuestionRepository;
import com.work.on.assignment.service.dataaccess.mapper.AssignmentDataAccessMapper;
import com.work.on.assignment.service.dataaccess.repository.QuestionJpaRepository;
import com.work.on.assignment.service.domain.entity.Question;
import com.work.on.assignment.service.domain.valueobject.QuestionId;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class QuestionRepositoryImpl implements QuestionRepository {

    private final QuestionJpaRepository questionJpaRepository;

    private final AssignmentDataAccessMapper assignmentDataAccessMapper;

    public QuestionRepositoryImpl(QuestionJpaRepository questionJpaRepository, AssignmentDataAccessMapper assignmentDataAccessMapper) {
        this.questionJpaRepository = questionJpaRepository;
        this.assignmentDataAccessMapper = assignmentDataAccessMapper;
    }

    @Override
    public Optional<Question> findQuestionById(QuestionId questionId) {
        return questionJpaRepository.findById(questionId).map(assignmentDataAccessMapper::questionEntityToQuestion);
    }

    @Override
    public Question createQuestion(Question question) {
        return assignmentDataAccessMapper.questionEntityToQuestion(
                questionJpaRepository.save(assignmentDataAccessMapper.questionToQuestionEntity(question)));
    }
}
