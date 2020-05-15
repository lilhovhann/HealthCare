/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.project.app.beans.auth;

import io.project.app.dto.PatientDTO;
import io.project.app.unicorn.PatientClient;
import io.project.app.usercontext.SessonController;
import java.io.Serializable;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

/**
 *
 * @author lilith
 */
@Named(value = "patientBean")
@ViewScoped
public class PatientBean implements Serializable {

    @Inject
    private PatientClient patientClient;

    private PatientDTO patient = new PatientDTO();

//    @Inject
//    private SessonController sessonController;

    public PatientBean() {
    }

    public String doRegister() {
        System.out.println("Start Register");

        PatientDTO patientRegistration = patientClient.Registration(patient);
        if (patientRegistration.getId() != null) {
//            sessonController.setPatient(patientRegistration);
            return "profile";
        }
        return "error";
    }

    public PatientDTO getPatient() {
        return patient;
    }

    public void setPatient(PatientDTO patient) {
        this.patient = patient;
    }

}
