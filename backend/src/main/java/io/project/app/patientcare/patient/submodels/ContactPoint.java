/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.project.app.patientcare.patient.submodels;

import java.io.Serializable;
import javax.annotation.ManagedBean;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 *
 * @author lilith
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class ContactPoint implements Serializable{
//      // from Element: extension
//  "system" : "<code>", // C? phone | fax | email | pager | url | sms | other
//  "value" : "<string>", // The actual contact point details
//  "use" : "<code>", // home | work | temp | old | mobile - purpose of this contact point
//  "rank" : "<positiveInt>", // Specify preferred order of use (1 = highest)
//  "period" : { Period } // Time period when the contact point was/is in use
    
    
    private String system;
    
    private String value;
    
    private String use;

   
     
    
  
}
