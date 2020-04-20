/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.project.app.patientcare.controllers;


import io.project.app.patientcare.models.Practitioner;
import io.project.app.patientcare.services.PractitionerService;

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
@RequestMapping("/api/v2/practitioners")
@Slf4j
public class PractitionerController {
    
    @Autowired
    private PractitionerService practitionerService;
        
    @PostMapping(path = "/practitioner", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> create(@RequestBody Practitioner practitioner) {
        log.info("Create practitioner");
        
        if(practitioner.getFirstname() == null){
            log.error("Could not create practitioner");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("You must fill practitioner name");
        }
        
        Practitioner savedPractitioner = practitionerService.createPractitioner(practitioner);
        return ResponseEntity.status(HttpStatus.OK).body(savedPractitioner);
    }
    
    @PostMapping(path = "/practitioner/update", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> update (@RequestBody Practitioner practitioner){
        log.info("update practitioner");
        
        if(practitioner.getId() == null){
            log.error("Could not create practitioner");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("You must fill practitioner name");
        }
        
       Practitioner updatedPractitioner = practitionerService.updatePractitioner(practitioner);  
        return ResponseEntity.status(HttpStatus.OK).body(updatedPractitioner);
    }
    
    @GetMapping(path = "/practitioner/find/one", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> find (@RequestParam Long id){
        log.info("find practitioner");
        
        if(id == null){
            log.error("could not find practitioner");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("you must fill practitioner id");
            
        }
        
        Practitioner practitionerById = practitionerService.getPractitionerById(id);
        return ResponseEntity.status(HttpStatus.OK).body(practitionerById);
    }
    
    @DeleteMapping(path = "/practitioner/id", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> delete(@RequestParam Long id){
        log.info("delete ppractitioneratient");
        
        if(id == null){
            log.error("could not delete");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("you must fill practitioner id");
        }
        
        practitionerService.removePractitioner(id);
        return ResponseEntity.status(HttpStatus.OK).body("Deleted practitioner with id "+id);
    }
    
    @GetMapping(path = "/practitioner", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findAll(){
       List<Practitioner> findAllSavedPractitioners = practitionerService.findAllSavedPractitioners();
       return ResponseEntity.status(HttpStatus.OK).body(findAllSavedPractitioners);
    }
    
}
