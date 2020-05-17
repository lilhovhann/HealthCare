package io.project.app.patient.submodels;

import io.project.app.patiient.submodels.enums.Gender;
import java.io.Serializable;


/**
 *
 * @author lilith
 */

public class ContactParty implements Serializable{
    
    private String name;
    
    
    private String address;
    
    public Gender[] getGenders() {
        return Gender.values();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    
}
