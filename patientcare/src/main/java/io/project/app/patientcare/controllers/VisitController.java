package io.project.app.patientcare.controllers;

import io.project.app.patientcare.models.Visit;
import io.project.app.patientcare.models.Account;
import io.project.app.patientcare.models.Practitioner;

import io.project.app.patientcare.services.AccountService;
import io.project.app.patientcare.services.PatientService;
import io.project.app.patientcare.services.PractitionerService;
import io.project.app.patientcare.services.VisitService;
import java.util.Optional;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author lilith
 */
@RestController
@RequestMapping("/api/v2/visit")
@Slf4j
public class VisitController {
    
    @Autowired
    private VisitService visitService;
    
    
    @PostMapping(path = "/makeVisit", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> create(@RequestBody Visit visit) {
        log.info("Create visit in controller");
        
        if(visit.getPractitionerId()== null){
            log.error("Could not create visit");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("You must fill practitioner id");
        }
      
        Optional<Visit> savedVisit =  visitService.createVisit(visit);
        
        return ResponseEntity.status(HttpStatus.OK).body(savedVisit.get());
    }
    
   
}
