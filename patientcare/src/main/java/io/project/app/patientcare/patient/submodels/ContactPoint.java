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
public class ContactPoint {
//      // from Element: extension
//  "system" : "<code>", // C? phone | fax | email | pager | url | sms | other
//  "value" : "<string>", // The actual contact point details
//  "use" : "<code>", // home | work | temp | old | mobile - purpose of this contact point
//  "rank" : "<positiveInt>", // Specify preferred order of use (1 = highest)
//  "period" : { Period } // Time period when the contact point was/is in use
    
    
    private enum system{phone, fax, email, pager, url, sms, other };
    
    private String value;
    
    private enum use{home, work, temp, old, mobile};
    
    Period period = new Period();   
}
