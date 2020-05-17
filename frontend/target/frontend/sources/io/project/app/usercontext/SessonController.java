/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.project.app.usercontext;

import io.project.app.patientcare.models.Account;
import io.project.app.patientcare.models.Patient;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author lilith
 */
@SessionScoped
@Named(value = "sessonController")
public class SessonController implements Serializable{
    
    
    private Account account = new Account();
    
    private Patient patient = new Patient();

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
    
    

}
