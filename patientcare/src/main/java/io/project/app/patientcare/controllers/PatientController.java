package io.project.app.patientcare.controllers;
import io.project.app.patientcare.models.Patient;
import io.project.app.patientcare.services.PatientService;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author lilith
 */
@RestController
@RequestMapping("/api/v2/patients")
@Slf4j
public class PatientController {
    
    @Autowired
    private PatientService patientService;
    
    @PostMapping(path = "/patient", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> create(@RequestBody Patient patient) {
        log.info("Create Patient");
        
        if(patient.getFirstname() == null){
            log.error("Could not create patient");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("You must fill patient name");
        }
        
        Patient savedPatent = patientService.createPatient(patient);
        return ResponseEntity.status(HttpStatus.OK).body(savedPatent);
    }
    
    @PostMapping(path = "/patient/update", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> update (@RequestBody Patient patient){
        log.info("update patient");
        
        if(patient.getId() == null){
            log.error("Could not create patient");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("You must fill patient name");
        }
        
       Patient updatedPatient = patientService.updatePatient(patient);  
        return ResponseEntity.status(HttpStatus.OK).body(updatedPatient);
    }
    
    @GetMapping(path = "/patient/find/one", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> find (@RequestParam Long id){
        log.info("find patient");
        
        if(id == null){
            log.error("could not find patient");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("you must fill patient id");
            
        }
        
        Patient patientById = patientService.getPatientById(id);
        return ResponseEntity.status(HttpStatus.OK).body(patientById);
    }
    
    @DeleteMapping(path = "/patient/id", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> delete(@RequestParam Long id){
        log.info("delete patient");
        
        if(id == null){
            log.error("could not delete");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("you must fill patient id");
        }
        
        patientService.removePatient(id);
        return ResponseEntity.status(HttpStatus.OK).body("Deleted patient with id "+id);
    }
    
    @GetMapping(path = "/patient", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findAll(){
       List<Patient> findAllSavedPatients = patientService.findAllSavedPatients();
       return ResponseEntity.status(HttpStatus.OK).body(findAllSavedPatients);
    }
}
