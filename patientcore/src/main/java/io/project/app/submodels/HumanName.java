package io.project.app.submodels;


import java.io.Serializable;
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

public class HumanName implements Serializable{
    
    private String use;
    
    private String text;
    
    private String family;

    
}
