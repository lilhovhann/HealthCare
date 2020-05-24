package io.project.app.beans.auth;

import io.project.app.models.enums.AddressUse;
import io.project.app.models.enums.ConsentRelationship;
import io.project.app.models.enums.ConsentStatus;
import io.project.app.models.enums.Gender;
import io.project.app.models.enums.HumanNameUse;
import io.project.app.models.enums.Language;
import io.project.app.models.enums.ProvisionType;
import io.project.app.models.Patient;
import io.project.app.unicorn.PatientClient;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
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

    private Patient patient = new Patient(); 
    
    private String patientId;

    public PatientBean() {
    }

    private FacesContext context;

    private ExternalContext externalContext;

    @PostConstruct // work after constructor
    public void init() {
        context = FacesContext.getCurrentInstance();
        externalContext = context.getExternalContext();
        patientId = this.getRequestParameter("patientId");

        if (patientId != null) {
            patient = patientClient.getOnePatient(patientId).getPatient();
        }
    }

    
   
    public Gender[] getGenders() {
        return Gender.values();
    }

    public Language[] getLanguageList() {
        return Language.values();
    }

    public HumanNameUse[] getHumanNameUseList() {
        return HumanNameUse.values();
    }

    public AddressUse[] getAddressUseList() {
        return AddressUse.values();
    }
    
    public ConsentStatus[] getConsentStatuseList(){
        return ConsentStatus.values();
    }
    
    public ProvisionType[] getProvisionTypeList(){
        return ProvisionType.values();
    }
    
    public ConsentRelationship[] getConsentRelationshipList(){
        return ConsentRelationship.values();
    }

    public String doRegister() {
        System.out.println("Start Register");

        Patient patientRegistration = patientClient.registration(patient);
        if (patientRegistration.getId() != null) {
            return "patientlist";
        }
        return "error";
    }

    private String getRequestParameter(String paramName) {
        String returnValue = null;
        if (externalContext.getRequestParameterMap().containsKey(paramName)) {
            returnValue = (externalContext.getRequestParameterMap().get(paramName));
        }
        return returnValue;
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

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

}
