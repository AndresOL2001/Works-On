package com.work.on.assigment.service.domain.ports.output.repository;

import com.work.on.assignment.service.domain.entity.Question;
import com.work.on.assignment.service.domain.valueobject.QuestionId;

import java.util.Optional;

public interface QuestionRepository {

    Optional<Question> findQuestionById(QuestionId questionId);

    Question createQuestion(Question file);
}
