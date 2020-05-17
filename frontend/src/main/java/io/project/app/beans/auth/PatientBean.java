/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.project.app.beans.auth;

import io.project.app.patient.enums.Gender;
import io.project.app.patient.enums.Language;
import io.project.app.patientcare.models.Patient;
import io.project.app.unicorn.PatientClient;
import java.io.Serializable;
import java.util.List;
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

    private Patient patient = new Patient(); // sa im  backendi nujn modelna

    public PatientBean() {
    }

    public Gender[] getGenders() {
        return Gender.values();
    }

    public Language[] getLanguageList() {
        return Language.values();
    }

    public String doRegister() {
        System.out.println("Start Register");

        Patient patientRegistration = patientClient.registration(patient);
        if (patientRegistration.getId() != null) {
//            sessonController.setPatient(patientRegistration);
            return "profile";
        }
        return "error";
    }

    public List<Patient> getPatientList() {
        return patientClient.getPatients().getPatientList();
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

}
