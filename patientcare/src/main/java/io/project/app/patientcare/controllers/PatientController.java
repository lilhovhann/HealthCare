package io.project.app.patientcare.controllers;

import io.project.app.patientcare.models.Account;
import io.project.app.patientcare.models.Login;
import io.project.app.patientcare.models.Patient;


import io.project.app.patientcare.services.AccountService;
import io.project.app.patientcare.services.PatientService;
import java.util.List;

import java.util.Optional;

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
@RequestMapping("/api/v2/join")
@Slf4j
public class PatientController {

    @Autowired
    private PatientService patientService;

    @PostMapping(path = "/creation", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> create(@RequestBody Patient patient) {
        log.info("Create patient");

        

        Optional<Patient> savedPatient = patientService.createPatient(patient);
        return ResponseEntity.status(HttpStatus.OK).body(savedPatient.get());
    }
    

    @PostMapping(path = "/patient/update", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> update(@RequestBody Patient patient) {
        log.info("update patient");

        if (patient.getId() == null) {
            log.error("Could not update patient");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("You must fill patient id");
        }

        Patient updatedPatient = patientService.updatePatient(patient);
        return ResponseEntity.status(HttpStatus.OK).body(updatedPatient);
    }
    


    @DeleteMapping(path = "/patient/id", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> delete(@RequestParam String id) {
        log.info("delete patient");

        if (id == null) {
            log.error("could not delete");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("you must fill account id");
        }

        patientService.removePatient(id);
        return ResponseEntity.status(HttpStatus.OK).body("Deleted patient with id " + id);
    }
    
 

    @GetMapping(path = "/patient", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findAll() {
        List<Patient> findAllSavedPatients = patientService.findAllSavedPatients();
        return ResponseEntity.status(HttpStatus.OK).body(findAllSavedPatients);
    }

}
