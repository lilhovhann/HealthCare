package io.project.app.patient.submodels;

import io.project.app.patiient.submodels.enums.ContactPointSystem;
import io.project.app.patiient.submodels.enums.ContactPointUse;
import java.io.Serializable;


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
    
    public ContactPointSystem[] getSystems() {
        return ContactPointSystem.values();
    }
    
     public ContactPointUse[] getContactPointUses() {
        return ContactPointUse.values();
    }
     
    
    private String value;
    
    

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
     
    
  
}
