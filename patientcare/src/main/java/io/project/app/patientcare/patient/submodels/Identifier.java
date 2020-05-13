/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.project.app.patientcare.patient.submodels;

/**
 *
 * @author lilith
 */
public class Identifier {
//    // from Element: extension
//  "use" : "<code>", // usual | official | temp | secondary | old (If known)
//  "type" : { CodeableConcept }, // Description of identifier
//  "system" : "<uri>", // The namespace for the identifier value
//  "value" : "<string>", // The value that is unique
//  "period" : { Period }, // Time period when id is/was valid for use
//  "assigner" : { Reference(Organization) } // Organization that issued id (may be just text)
    
    
    private String use;
    
    private String type;
    
    private String system;
    
    private String value;
    
    private String period;
    
    private String assigner;
    
}
