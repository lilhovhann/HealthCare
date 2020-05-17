/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.project.app.patientcare.patient.submodels;

import java.io.Serializable;
import javax.annotation.ManagedBean;

/**
 *
 * @author lilith
 */

public class ContactPoint implements Serializable{
//      // from Element: extension
//  "system" : "<code>", // C? phone | fax | email | pager | url | sms | other
//  "value" : "<string>", // The actual contact point details
//  "use" : "<code>", // home | work | temp | old | mobile - purpose of this contact point
//  "rank" : "<positiveInt>", // Specify preferred order of use (1 = highest)
//  "period" : { Period } // Time period when the contact point was/is in use
    
    
    public System[] getSystems() {
        return System.values();
    }
    
    private String value;
    
     public ContactPointUse[] getContactPointUses() {
        return ContactPointUse.values();
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
     
    
  
}
