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
public class Address {
//     // from Element: extension
//  "use" : "<code>", // home | work | temp | old | billing - purpose of this address
//  "type" : "<code>", // postal | physical | both
//  "text" : "<string>", // Text representation of the address
//  "line" : ["<string>"], // Street name, number, direction & P.O. Box etc.
//  "city" : "<string>", // Name of city, town etc.
//  "district" : "<string>", // District name (aka county)
//  "state" : "<string>", // Sub-unit of country (abbreviations ok)
//  "postalCode" : "<string>", // Postal code for area
//  "country" : "<string>", // Country (e.g. can be ISO 3166 2 or 3 letter code)
//  "period" : { Period } // Time period when address was/is in use
    
    private enum use{home, work, temp, old, billing};
    
    private enum type{postal, physical, both};
    
    private String text;
    
    private String line[];
    
    private String city;
    
    private String district;
    
    private String state;
    
    private String postalCode;
    
    private String country;
    
    Period period = new Period();
}


