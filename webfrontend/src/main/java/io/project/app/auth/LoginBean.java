package io.project.app.auth;

import io.project.app.unicorn.AuthClient;
//import io.project.app.security.SessionContext;
import io.project.app.util.CommonConstants;
import io.project.app.patientcare.models.Account;
//import io.project.app.constant.data.AccountType;
import io.project.app.api.requests.FileRequest;
import io.project.app.api.requests.LoginRequest;
//import io.project.app.unicorn.ProfileClient;

import java.io.Serializable;
import java.util.PropertyResourceBundle;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import lombok.Getter;
import lombok.Setter;
import org.apache.log4j.Logger;

/**
 *
 * @author armdev
 */
@Named(value = "loginBean")
@ViewScoped
public class LoginBean implements Serializable {

    private static final Logger LOGGER = Logger.getLogger(LoginBean.class);

    private static final long serialVersionUID = 1L;

    @Inject
    private AuthClient accountAuthClient;

//    @Inject
//    private SessionContext sessionContext = null;

    @Setter
    @Getter
    private LoginRequest loginModel;
    private String ipAddress;

//    @Inject
//    private ProfileClient profileClient;

    @Setter
    @Getter
    private Account account;

    public LoginBean() {
        LOGGER.info("##LoginBean called");
    }

    @PostConstruct
    public void init() {
        loginModel = new LoginRequest();
        account = new Account();
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext ex = context.getExternalContext();

    }

//    public String loginUser() {
//        User user = userAuthClient.userLogin(loginModel);
//        if (user.getEmail() == null) {
//            FacesMessage msg = new FacesMessage(getBundle().getString("nouser"), getBundle().getString("nouser"));
//            FacesContext.getCurrentInstance().addMessage(null, msg);
//            return null;
//        }
//
//        if (user.getStatus().equals(CommonConstants.ACTIVATED)) {
//            sessionContext.setUser(user);
//            LOGGER.info("##LoginBean findUserAvatar");
//            FileRequest findUserAvatar = profileClient.findUserAvatar(user.getId());
//
//            if (findUserAvatar.getId() != null) {
//                LOGGER.info("###user avatar id is " + findUserAvatar.getId());
//
//                sessionContext.setUserAvatarId(findUserAvatar.getId());
//            } else {
//                LOGGER.error("##LoginBean NO? AVATAR ID ?");
//            }
//
//            sessionContext.init();
//            return "dashboard";
//
//        }
//        FacesMessage msg = new FacesMessage(getBundle().getString("nouser"), getBundle().getString("nouser"));
//        FacesContext.getCurrentInstance().addMessage(null, msg);
//        return null;
//
//    }

    public String registerAccount() {
        LOGGER.info("Register new account, started");
        Account returnedAccount = accountAuthClient.getAccountByPhone(account.getPhone());
        if (returnedAccount.getId() != null) {
            LOGGER.info("Account tried to register with busy phone " + returnedAccount.getPhone());
            FacesMessage msg = new FacesMessage(getBundle().getString("emailbusy"), getBundle().getString("phonebusy"));
            FacesContext.getCurrentInstance().addMessage(null, msg);
            return null;
        }

        LOGGER.info("Register new account");

        Account returnedModel = accountAuthClient.accountRegistration(account);
        if (returnedModel.getId() != null) {
            return "success";
        } else {
            return "fail";
        }
    }
    
    
//    public AccountType[] getAccountList() {
//        return AccountType.values();
//    }

    public void validatePassword(ComponentSystemEvent event) {

        FacesContext fc = FacesContext.getCurrentInstance();

        UIComponent components = event.getComponent();

        // get password
        UIInput uiInputPassword = (UIInput) components.findComponent("password");
        String passwd = uiInputPassword.getLocalValue() == null ? ""
                : uiInputPassword.getLocalValue().toString();
        String passwordId = uiInputPassword.getClientId();

        // get confirm password
        UIInput uiInputConfirmPassword = (UIInput) components.findComponent("confirmPassword");
        String confirmPassword = uiInputConfirmPassword.getLocalValue() == null ? ""
                : uiInputConfirmPassword.getLocalValue().toString();

        // Let required="true" do its job.
        if (passwd.isEmpty() || confirmPassword.isEmpty()) {
            return;
        }

        if (!passwd.equals(confirmPassword)) {

            FacesMessage msg = new FacesMessage("Password must match confirm password");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            fc.addMessage(passwordId, msg);
            fc.renderResponse();

        }

    }

    public PropertyResourceBundle getBundle() {
        FacesContext context = FacesContext.getCurrentInstance();
        return context.getApplication().evaluateExpressionGet(context, "#{i18n}", PropertyResourceBundle.class);
    }

    public void publishMessage() {
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, getBundle().getString("registersuccess"), getBundle().getString("registersuccess"));
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

}
