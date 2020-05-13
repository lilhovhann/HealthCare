package io.project.app.patientcare.repositories;

import io.project.app.patientcare.models.Account;
import io.project.app.patientcare.models.Patient;


import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository

public interface PatientRepository  extends MongoRepository<Patient, String> { 
    
    public void deleteById(String patientId);
}   
