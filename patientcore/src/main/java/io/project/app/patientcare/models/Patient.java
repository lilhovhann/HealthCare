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

    private HumanName name = new HumanName();

    private String gender;

    private Date birthdate;

    private boolean deceasedBoolean;

    private Date deceasedDateTime;

    private String language;

    private String address ; //make simple now

    private ContactPoint telecom = new ContactPoint();

//    Attachment photo = new Attachment();
    private ContactParty contactParty = new ContactParty();

    private HumanName practitionerName = new HumanName();

}
