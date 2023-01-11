package com.work.on.assignment.service.dataaccess.adapter;

import com.work.on.assigment.service.domain.ports.output.repository.FileRepository;
import com.work.on.assignment.service.dataaccess.mapper.AssignmentDataAccessMapper;
import com.work.on.assignment.service.dataaccess.repository.FileJpaRepository;
import com.work.on.assignment.service.domain.entity.File;
import com.work.on.domain.valueobject.FileId;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FileRepositoryImpl implements FileRepository {

    private FileJpaRepository fileJpaRepository;

    private AssignmentDataAccessMapper assignmentDataAccessMapper;

    public FileRepositoryImpl(FileJpaRepository fileJpaRepository, AssignmentDataAccessMapper assignmentDataAccessMapper) {
        this.fileJpaRepository = fileJpaRepository;
        this.assignmentDataAccessMapper = assignmentDataAccessMapper;
    }

    @Override
    public Optional<File> findFileById(FileId file) {
        return fileJpaRepository.findById(file).map(assignmentDataAccessMapper::fileEntityToFile);
    }

    @Override
    public File createFile(File file) {
        return assignmentDataAccessMapper.fileEntityToFile(fileJpaRepository.save(assignmentDataAccessMapper.fileToFileEntity(file)));
    }
}
