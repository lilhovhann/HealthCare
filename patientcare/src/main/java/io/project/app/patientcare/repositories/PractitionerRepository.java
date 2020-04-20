package io.project.app.patientcare.repositories;

import io.project.app.patientcare.models.Practitioner;
import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

/**
 *
 * @author lilith
 */
@Repository
public interface PractitionerRepository extends CrudRepository<Practitioner, Long>{

    
    
}
