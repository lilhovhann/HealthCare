package io.project.app.models;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode

/**
 *
 * @author lilith
 */


public class Login implements Serializable {
    
    private static final long serialVersionUID = 5005662345607157416L;
    
    private String phone;   
    private String password;
   
}
