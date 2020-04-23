package io.project.app.patientcare.services;


import io.project.app.patientcare.models.Visit;
import io.project.app.patientcare.repositories.VisitRepository;

import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 *
 * @author lilith
 */

@Service
@Slf4j
public class VisitService {
    
    @Autowired
    private VisitRepository visitRepository;
    
    public Optional<Visit> createVisit(Visit visit){
        log.info("service: create visit");
        
        
        final Visit createNewVisit = new Visit(visit.getVisitDate(),
                visit.getPatientId(), 
                visit.getPractitionerId(), 
                visit.getVisitReason());
        
        final Visit savedVisit = visitRepository.save(createNewVisit);
        return Optional.ofNullable(savedVisit);
    }
   
    
    public void getAllVisits(){
        log.info("getAllVisits");
    }
    
}
