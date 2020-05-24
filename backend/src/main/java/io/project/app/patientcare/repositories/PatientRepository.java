package io.project.app.patientcare.repositories;

import io.project.app.models.Patient;

import org.springframework.data.mongodb.repository.MongoRepository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface PatientRepository extends MongoRepository<Patient, String> {

    @Override
    public void deleteById(String patientId);
}
