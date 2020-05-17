package io.project.app.patientcare.patient.submodels;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;


/**
 *
 * @author gegham
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode


public class ConsentProvision {
    
    private String type; 
    
    private Period period = new Period();
    
    private String actor;

}
