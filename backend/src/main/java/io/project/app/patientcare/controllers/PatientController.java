package io.project.app.patientcare.controllers;

import io.project.app.api.response.PatientApiResponse;
import io.project.app.models.Patient;

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
@RequestMapping("/api/v2/patients")
@Slf4j
public class PatientController {

    @Autowired
    private PatientService patientService;

    @PostMapping(path = "/creation", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> create(@RequestBody Patient patient) {
        log.info("Create patient " + patient.toString());

        Optional<Patient> savedPatient = patientService.createPatient(patient);
        return ResponseEntity.status(HttpStatus.OK).body(savedPatient.get());
    }

    @DeleteMapping(path = "/patient/delete/id", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> delete(@RequestParam String id) {
        log.info("delete patient");

        if (id == null) {
            log.error("could not delete");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("you must fill account id");
        }

        patientService.removePatient(id);
        return ResponseEntity.status(HttpStatus.OK).body("Deleted patient with id " + id);
    }

    @GetMapping(path = "/find/all/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findAll() {
        List<Patient> findAllSavedPatients = patientService.findAllSavedPatients();

        PatientApiResponse response = new PatientApiResponse();
        response.getPatientList().addAll(findAllSavedPatients);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping(path = "/find/one", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> one(@RequestParam String patientId) {
        Optional<Patient> findOne = patientService.findOne(patientId);
        PatientApiResponse response = new PatientApiResponse();
        if (findOne.isPresent()) {
            response.setPatient(findOne.get());
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);

    }

}
