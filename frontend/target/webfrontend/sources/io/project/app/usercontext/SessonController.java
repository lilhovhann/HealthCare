/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.project.app.usercontext;

import io.project.app.dto.AccountDTO;
import io.project.app.dto.PatientDTO;
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
    
    
    private AccountDTO account = new AccountDTO();
    
    private PatientDTO patient = new PatientDTO();

    public PatientDTO getPatient() {
        return patient;
    }

    public void setPatient(PatientDTO patient) {
        this.patient = patient;
    }
    

    public AccountDTO getAccount() {
        return account;
    }

    public void setAccount(AccountDTO account) {
        this.account = account;
    }
    
    
    
}
