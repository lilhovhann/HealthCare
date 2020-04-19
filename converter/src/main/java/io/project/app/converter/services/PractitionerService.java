package io.project.app.converter.services;

import io.project.app.converter.models.Patient;
import io.project.app.converter.models.Practitioner;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 *
 * @author lilith
 */

@Service
@Slf4j
public class PractitionerService {
    public void createPractitioner(Practitioner practitioner){
        log.info("creating Practitioner");
    }
    
    public void updatePractitioner(Practitioner practitioner){
        log.info("Creating Practitioner");
    }
    
    public void getPractitionerById(String PractitionerId){
        log.info("Finf Practitioner with id and return");
    }
    
    public void removePractitioner(String PractitionerId) {
        log.info("find Practitioner with id and delete");
    }
    
    public void findAllSavedPractitioners(){
        log.info("find all Practitioner, return Array List or List");
    }
}
