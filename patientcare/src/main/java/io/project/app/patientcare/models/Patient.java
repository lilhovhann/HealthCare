package io.project.app.patientcare.models;

import io.project.app.patientcare.patient.submodels.Address;
import io.project.app.patientcare.patient.submodels.Attachment;
import io.project.app.patientcare.patient.submodels.ContactParty;
import io.project.app.patientcare.patient.submodels.ContactPoint;
import io.project.app.patientcare.patient.submodels.HumanName;

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
    
    private boolean active;
    
    HumanName name = new HumanName();
    
    ContactPoint telecom = new ContactPoint();
    
    private enum gender{male, female, other, unknown};
    
    private Date birthdate;
  
    private boolean deceasedBoolean;
    
    private Date deceasedDateTime;
    
    Address address = new Address();
    
    Attachment photo = new Attachment();
    
    ContactParty contactParty = new ContactParty();
    
    private enum language{armenian, english, russian};
    
    HumanName practitionerName = new HumanName();
   
}
