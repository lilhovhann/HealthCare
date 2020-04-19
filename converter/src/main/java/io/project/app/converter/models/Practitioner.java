package io.project.app.converter.models;

import java.io.Serializable;
import java.util.Date;
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
public class Practitioner implements Serializable {
    
    private static final long serialVersionUID = 5005662345607157416L;
    private String id;
    
    private String firstname;
    private String lastname;
    private String gender;
    private String phone;
    private String viber;
    private Integer status;
    private Date patientRegisterDate;
    private Date birthDate;
    
}
