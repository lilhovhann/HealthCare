package io.project.app.patientcare.services;

import io.project.app.patientcare.models.Practitioner;
import io.project.app.patientcare.repositories.PractitionerRepository;
import java.util.List;
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
public class PractitionerService {
    
    @Autowired
    private PractitionerRepository practitionerRepository;
    
    public Practitioner createPractitioner(Practitioner practitioner){
        log.info("creating practitioner");
        Practitioner savedModel = practitionerRepository.save(practitioner);
        return savedModel;
    }
    
    public Practitioner updatePractitioner(Practitioner practitioner){
        log.info("Creating PatiPractitionerent");
        if(practitioner.getId() == null){
            log.error("provide practitioner id for update");
            return new Practitioner();
        }
        log.info("Update practitioner with id "+ practitioner.getId());
        Practitioner updatedPractitioner = practitionerRepository.save(practitioner);
        return practitioner;
    }
    
    public Practitioner getPractitionerById(Long practitionerId){
        log.info("Find practitioner with id and return");
        Optional<Practitioner> findOne = practitionerRepository.findById(practitionerId);
        if(findOne.isPresent()){
            log.info("found practitioner by id "+practitionerId);
            return findOne.get();
        }
        return new Practitioner(); //return empty object
    }
    
    public void removePractitioner(Long practitionerId) {
        log.info("find practitioner with id and delete");
        practitionerRepository.deleteById(practitionerId);
    }
    
    public List<Practitioner> findAllSavedPractitioners(){
        log.info("find all practitioners, return Array List or List");
        return (List<Practitioner>) practitionerRepository.findAll();
      
    }
}
