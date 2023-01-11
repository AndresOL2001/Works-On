package com.work.on.assignment.service.dataaccess.mapper;

import com.work.on.assignment.service.dataaccess.entity.*;
import com.work.on.assignment.service.domain.entity.*;
import com.work.on.assignment.service.domain.valueobject.PollId;
import com.work.on.assignment.service.domain.valueobject.QuestionId;
import com.work.on.assignment.service.domain.valueobject.TaskId;
import com.work.on.domain.valueobject.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class AssignmentDataAccessMapper {
    public Assignment assignmentEntityToAssignment(AssignmentEntity assignmentEntity) {

        return Assignment.newBuilder()
                .customerId(new CustomerId(assignmentEntity.getCustomer().getCustomerId()))
                /*.users(assignmentEntity.getUsers().stream().map(userEntity ->
                                User.newBuilder()
                                        .id(new UserId(userEntity.getUserId()))
                                        .assignmentId(new AssignmentId(userEntity.getAssignment().getAssignmentId()))
                                        .build()

                        ).collect(Collectors.toList()))*/
                .points(new Money(assignmentEntity.getPoints()))
                .tasks(assignmentEntity.getTasks().stream().map(taskEntity ->
                                Task.newBuilder()
                                        .taskName(taskEntity.getTaskName())
                                        .taskDescription(taskEntity.getTaskDescription())
                                        .id(new TaskId(taskEntity.getTaskId()))
                                        .assignmentId(new AssignmentId(taskEntity.getAssignment().getAssignmentId()))
                                       /* .files(taskEntity.getFiles().stream().map(fileEntity ->
                                                File.newBuilder()
                                                        .id(new FileId(fileEntity.getFileId()))
                                                        .task(new TaskId(fileEntity.getFileId()))
                                                        .build())
                                                .collect(Collectors.toList()))*/
                                        .build()
                        ).collect(Collectors.toList()))
                .topic(assignmentEntity.getTopic())
                .description(assignmentEntity.getDescription())
                .deliveryDate(assignmentEntity.getDeliveryDate())
                .creationDate(assignmentEntity.getCreationDate())
                .id(new AssignmentId(assignmentEntity.getAssignmentId()))
                .build();
    }

    public AssignmentEntity assignmentToAssignmentEntity(Assignment assignment) {
        AssignmentEntity assignmentEntity = AssignmentEntity.builder()
                .assignmentId(assignment.getId().getValue())
                .creationDate(assignment.getCreationDate())
                .topic(assignment.getTopic())
                .customer(  CustomerEntity.builder()
                        .customerId(assignment.getCustomerId().getValue())
                        .build()
                )
                .deliveryDate(assignment.getDeliveryDate())
                .description(assignment.getDescription())
                .points(assignment.getPoints().getAmount())
                .tasks(assignment.getTasks().stream().map(task ->
                        TaskEntity.builder()
                                .taskName(task.getTaskName())
                                .taskDescription(task.getTaskDescription())
                                .taskId(task.getId().getValue())
                               /* .taskPolls(task.getTaskPolls().stream().map(poll ->
                                                PollEntity.builder()
                                                        .pollId(poll.getId().getValue())
                                                        .questionList(poll.getQuestionList().stream().map(question ->
                                                                QuestionEntity.builder()
                                                                        .correctAnswer(question.getCorrectAnswer())
                                                                        .questionId(question.getId().getValue())
                                                                        .question(question.getQuestion())
                                                                        .build()
                                                        ).collect(Collectors.toList()))
                                                        .build()
                                        ).collect(Collectors.toList()))*/
                                .build()
                        ).collect(Collectors.toList()))
                .build();

        assignmentEntity.getTasks().forEach(taskEntity -> taskEntity.setAssignment(assignmentEntity));

        return assignmentEntity;

    }

    public Customer customerEntityToCustomer(CustomerEntity customerEntity) {

        return (Customer) Customer.newBuilder()
                .id(new CustomerId(customerEntity.getCustomerId()))
                .build();
    }

    public CustomerEntity customerToCustomerEntity(Customer customer) {

        return CustomerEntity.builder()
                .customerId(customer.getId().getValue())
                .build();

    }

    public User userEntityToUser(UserEntity userEntity) {
        return User.newBuilder()
                .assignmentId(new AssignmentId(userEntity.getAssignment().getAssignmentId()))
                .id(new UserId(userEntity.getUserId()))
                .build();
    }

    public UserEntity userToUserEntity(User user) {
        return UserEntity.builder()
                .userId(user.getId().getValue())
                .build();
    }

    public FileEntity fileToFileEntity(File file) {

        return FileEntity.builder()
                .fileId(file.getId().getValue())
                .build();
    }


    public File fileEntityToFile(FileEntity fileEntity) {
        return File.newBuilder()
                .id(new FileId(fileEntity.getFileId()))
                .build();
    }

    public  Poll polEntityToPol(PollEntity pollEntity) {
        return Poll.newBuilder()
                .id(new PollId(pollEntity.getPollId()))
                .questionList(pollEntity.getQuestionList().stream().map(questionEntity ->
                        Question.newBuilder()
                                .correctAnswer(questionEntity.getCorrectAnswer())
                                .id(new QuestionId(questionEntity.getQuestionId()))
                                .pollId(new PollId(questionEntity.getPoll().getPollId()))
                                .build()
                        ).collect(Collectors.toList()))
                .taskId(new TaskId(pollEntity.getTask().getTaskId()))
                .build();
    }

    public  PollEntity polToPolEntity (Poll poll) {
        return PollEntity.builder()
                .pollId(poll.getId().getValue())
                .questionList(poll.getQuestionList().stream().map(questionEntity ->
                        QuestionEntity.builder()
                                .correctAnswer(questionEntity.getCorrectAnswer())
                                .questionId(questionEntity.getId().getValue())
                                .build()
                ).collect(Collectors.toList()))
                .build();
    }

    public Question questionEntityToQuestion(QuestionEntity questionEntity) {

        return Question.newBuilder()
                .question(questionEntity.getQuestion())
                .id(new QuestionId(questionEntity.getQuestionId()))
                .correctAnswer(questionEntity.getCorrectAnswer())
                .pollId(new PollId(questionEntity.getPoll().getPollId()))
                .build();
    }

    public QuestionEntity questionToQuestionEntity(Question question){
        return QuestionEntity.builder()
                .questionId(question.getId().getValue())
                .question(question.getQuestion())
                .correctAnswer(question.getCorrectAnswer())
                .build();
    }

    public TaskEntity  taskToTaskEntity(Task task) {
        return TaskEntity.builder()
                .taskDescription(task.getTaskDescription())
                .taskName(task.getTaskName())
                .taskId(task.getId().getValue())
                .build();
    }

    public Task taskEntityToTask(TaskEntity taskEntity) {
        return Task.newBuilder()
                .taskDescription(taskEntity.getTaskDescription())
                .taskName(taskEntity.getTaskName())
                .id(new TaskId(taskEntity.getTaskId()))
                .build();
    }

    public List<TaskEntity> tasksToTasksEntities(List<Task> tasks) {
        return tasks.stream().map(task ->
                TaskEntity.builder()
                        /*.assignment(AssignmentEntity.builder()
                                .assignmentId(task.getAssignmentId().getValue())
                                .build())*/
                        .taskDescription(task.getTaskDescription())
                        .taskName(task.getTaskName())
                        .taskId(task.getId().getValue())
                        .build()
                ).collect(Collectors.toList());
    }

    public List<Task> taskEntitiesToTasks(List<TaskEntity> entities) {
        return entities.stream().map(taskEntity ->
                Task.newBuilder()
                        .assignmentId(new AssignmentId(taskEntity.getAssignment().getAssignmentId()))
                        .taskDescription(taskEntity.getTaskDescription())
                        .taskName(taskEntity.getTaskName())
                        .id(new TaskId(taskEntity.getTaskId()))
                        .build()
                ).collect(Collectors.toList());
    }
}
