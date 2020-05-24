package io.project.app.usercontext;

import io.project.app.models.Account;
import io.project.app.models.Patient;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author lilith
 */
@SessionScoped
@Named(value = "sessonController")
public class SessionController implements Serializable{
    
    private static final long serialVersionUID = 1L;

    private static final org.apache.log4j.Logger LOGGER = org.apache.log4j.Logger.getLogger(SessionController.class);
    
    private Account account = new Account();
    
    private Patient patient = new Patient();
    
    private String userAvatarId;
    
    public SessionController() {

    }
    
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
    
    @SuppressWarnings("unchecked")
    @PostConstruct
    public void init() {

    }
    
    
    public String getUserAvatarId() {
        return userAvatarId;
    }

    public void setUserAvatarId(String userAvatarId) {
        this.userAvatarId = userAvatarId;
    }

    

}
