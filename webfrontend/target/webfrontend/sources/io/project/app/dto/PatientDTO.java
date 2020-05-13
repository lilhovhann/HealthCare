package io.project.app.dto;

import io.project.app.patient.submodels.Address;
import io.project.app.patient.submodels.Attachment;
import io.project.app.patient.submodels.ContactParty;
import io.project.app.patient.submodels.ContactPoint;
import io.project.app.patient.submodels.HumanName;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Id;

/**
 *
 * @author lilith
 */


public class PatientDTO implements Serializable {

    private static final long serialVersionUID = 5005662345607157416L;
    
    @Id
    private String id;
    
    private boolean active;
    
    HumanName name = new HumanName();
    
    ContactPoint telecom = new ContactPoint();
    
    private enum gender{male, female, other, unknown};
    
    private Date date;
  
    private boolean deceasedBoolean;
    
    private Date deceasedDateTime;
    
    Address address = new Address();
    
    Attachment photo = new Attachment();
    
    ContactParty contactParty = new ContactParty();
    
    private enum language{armenian, english, russian};

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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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
   
}
