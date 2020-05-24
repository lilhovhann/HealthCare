package io.project.app.patientcare.services;

import io.project.app.models.Patient;
import io.project.app.patientcare.repositories.PatientRepository;
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
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public Optional<Patient> createPatient(Patient patient) {
     //tox save u udate nujn@ lini, ete id ka update kani

        final Patient savedPatient = patientRepository.save(patient);

        return Optional.ofNullable(savedPatient);
    }

   
    
     public Optional<Patient> findOne(String patientId) {
         
         return patientRepository.findById(patientId);
       
      
    }

    public void removePatient(String patientId) {
        log.info("find patient with id and delete");
        patientRepository.deleteById(patientId);
    }

    public List<Patient> findAllSavedPatients() {
        log.info("find all patients, return Array List or List");
        return patientRepository.findAll();
    }
}
