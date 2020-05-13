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
public class HumanName {
//     // from Element: extension
//  "use" : "<code>", // usual | official | temp | nickname | anonymous | old | maiden
//  "text" : "<string>", // Text representation of the full name
//  "family" : "<string>", // Family name (often called 'Surname')
//  "given" : ["<string>"], // Given names (not always 'first'). Includes middle names
//  "prefix" : ["<string>"], // Parts that come before the name
//  "suffix" : ["<string>"], // Parts that come after the name
//  "period" : { Period } // Time period when name was/is in use
    
    public enum use { usual, official, temp, nickname, anonymous, old, maiden}; 
    
    private String text;
    
    private String family;
    
    private String given[];
    
    private String prefix[];
    
    private String suffix[];
    
    Period period = new Period();
    
}
