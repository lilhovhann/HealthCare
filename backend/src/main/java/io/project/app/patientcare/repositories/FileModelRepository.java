package io.project.app.patientcare.repositories;


import io.project.app.models.FileModel;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface FileModelRepository extends MongoRepository<FileModel, String> {

    
    Optional<FileModel> findByIdAndUserId(String id, String userId);

    Optional<FileModel> findByUserId(String userId);
    
    
}
