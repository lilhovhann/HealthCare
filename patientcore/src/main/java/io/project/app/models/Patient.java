package io.project.app.models;

import io.project.app.models.enums.ConsentStatus;
import io.project.app.submodels.Address;
import io.project.app.submodels.Attachment;
import io.project.app.submodels.ConsentProvision;
import io.project.app.submodels.ContactParty;
import io.project.app.submodels.HumanName;

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

    private HumanName name = new HumanName();

    private String gender;

    private Date birthdate;

    private boolean deceasedBoolean;

    private Date deceasedDateTime;

    private String language;

    private String phone;

    private String email;
    
    private String viber; 
    

    private Address address = new Address(); 

    private String status;

    private ConsentProvision provision = new ConsentProvision();

    private Attachment photo = new Attachment();
    
    private ContactParty contactParty = new ContactParty();

    private HumanName practitionerName = new HumanName();

}
