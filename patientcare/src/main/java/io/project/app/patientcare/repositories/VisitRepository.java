package io.project.app.patientcare.repositories;

import io.project.app.patientcare.models.Visit;
import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

/**
 *
 * @author lilith
 */
@Repository
public interface VisitRepository extends CrudRepository<Visit, Long>{

    
    
}
