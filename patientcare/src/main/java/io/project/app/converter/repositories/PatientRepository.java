package io.project.app.converter.repositories;

import io.project.app.converter.models.Patient;
import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

/**
 *
 * @author lilith
 */
@Repository
public interface PatientRepository extends CrudRepository<Patient, Long>{

    
    
}
