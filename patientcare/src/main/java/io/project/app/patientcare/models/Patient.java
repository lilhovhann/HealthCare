package io.project.app.patientcare.models;

import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode

/**
 *
 * @author lilith
 */

@Document("patient")
public class Patient implements Serializable {

    private static final long serialVersionUID = 5005662345607157416L;
    
    @Id
    private String id;
    
    private String firstname;
    
    private String lastname;

    private String phone;

    private String email;

   

    private String middlename;

    private Date registerDate;

    
}
