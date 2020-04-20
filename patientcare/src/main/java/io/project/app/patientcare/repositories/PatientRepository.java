package io.project.app.patientcare.repositories;

import io.project.app.patientcare.models.Patient;
import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

/**
 *
 * @author lilith
 */
@Repository
public interface PatientRepository extends CrudRepository<Patient, Long>{

    
    
}
