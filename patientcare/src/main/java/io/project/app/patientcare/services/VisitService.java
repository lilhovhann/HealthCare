package io.project.app.patientcare.services;
import io.project.app.patientcare.models.Visit;
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
    private PractitionerService practitionerService;
    
    @Autowired
    private PatientService patientService;
    
    public void createVisit(Long patientId, String practitionerId){
        practitionerService.getPractitionerById(practitionerId);
        patientService.getPatientById(patientId);
        Visit newVisit = new Visit();
        newVisit.setPatient(null);
        log.info("create visit");
    }
    
    public void getAllVisits(){
        log.info("getAllVisits");
    }
    
}
