package io.project.app.submodels;

import java.io.Serializable;
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
public class ConsentProvision implements Serializable{
    
    private String type; 
    
    private Period period = new Period();
    
    private String actor;

}
