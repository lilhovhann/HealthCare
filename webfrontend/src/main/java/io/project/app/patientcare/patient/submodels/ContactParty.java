/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.project.app.patientcare.patient.submodels;

import java.io.Serializable;
import javax.annotation.ManagedBean;

/**
 *
 * @author lilith
 */
@ManagedBean
public class ContactParty implements Serializable{
    
    private String name;
    
    public Gender[] getGenders() {
        return Gender.values();
    }
    
    private String address;

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
