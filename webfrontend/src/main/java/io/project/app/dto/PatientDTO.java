
package io.project.app.dto;

import io.project.app.patientcare.patient.submodels.Address;
import io.project.app.patientcare.patient.submodels.Attachment;
import io.project.app.patientcare.patient.submodels.ContactParty;
import io.project.app.patientcare.patient.submodels.ContactPoint;
import io.project.app.patientcare.patient.submodels.Gender;
import io.project.app.patientcare.patient.submodels.HumanName;
import io.project.app.patientcare.patient.submodels.Language;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 *
 * @author lilith
 */


public class PatientDTO implements Serializable {

    private static final long serialVersionUID = 5005662345607157416L;
    
    
    private String id;
    
    private boolean active;
    
    HumanName name = new HumanName();
    
    ContactPoint telecom = new ContactPoint();
    
    public Gender[] getGenders() {
        return Gender.values();
    }
    
    private Date birthdate;
  
    private boolean deceasedBoolean;
    
    private Date deceasedDateTime;
    
    Address address = new Address();
    
    Attachment photo = new Attachment();
    
    ContactParty contactParty = new ContactParty();
    
    public Language[] getLanguages() {
        return Language.values();
    }
    
    HumanName practitionerName = new HumanName();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public HumanName getName() {
        return name;
    }

    public void setName(HumanName name) {
        this.name = name;
    }

    public ContactPoint getTelecom() {
        return telecom;
    }

    public void setTelecom(ContactPoint telecom) {
        this.telecom = telecom;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public boolean isDeceasedBoolean() {
        return deceasedBoolean;
    }

    public void setDeceasedBoolean(boolean deceasedBoolean) {
        this.deceasedBoolean = deceasedBoolean;
    }

    public Date getDeceasedDateTime() {
        return deceasedDateTime;
    }

    public void setDeceasedDateTime(Date deceasedDateTime) {
        this.deceasedDateTime = deceasedDateTime;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Attachment getPhoto() {
        return photo;
    }

    public void setPhoto(Attachment photo) {
        this.photo = photo;
    }

    public ContactParty getContactParty() {
        return contactParty;
    }

    public void setContactParty(ContactParty contactParty) {
        this.contactParty = contactParty;
    }

    public HumanName getPractitionerName() {
        return practitionerName;
    }

    public void setPractitionerName(HumanName practitionerName) {
        this.practitionerName = practitionerName;
    }
   
    
}
