package io.project.app.converter.services;

import io.project.app.converter.models.Patient;
import io.project.app.converter.repositories.PatientRepository;
import java.util.ArrayList;
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
    
    public Patient createPatient(Patient patient){
        log.info("creating patient");
        Patient savedModel = patientRepository.save(patient);
        return savedModel;
    }
    
    public Patient updatePatient(Patient patient){
        log.info("Creating Patient");
        if(patient.getId() == null){
            log.error("provide patient id for update");
            return new Patient();
        }
        log.info("Update patient with id "+ patient.getId());
        Patient updatedPatient = patientRepository.save(patient);
        return patient;
    }
    
    public Patient getPatientById(Long patientId){
        log.info("Find patient with id and return");
        Optional<Patient> findOne = patientRepository.findById(patientId);
        if(findOne.isPresent()){
            log.info("found patient by id "+patientId);
            return findOne.get();
        }
        return new Patient(); //return empty object
    }
    
    public void removePatient(Long patientId) {
        log.info("find patient with id and delete");
        patientRepository.deleteById(patientId);
    }
    
    public List<Patient> findAllSavedPatients(){
        log.info("find all patients, return Array List or List");
        return (List<Patient>) patientRepository.findAll();
      
    }
}
