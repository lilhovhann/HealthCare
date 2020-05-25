package io.project.app.beans.auth;

import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;

@Named
@RequestScoped
public class LogoutBean implements Serializable {

    private static final Logger LOGGER = Logger.getLogger(LogoutBean.class);
    private static final long serialVersionUID = 1L;

    private FacesContext context = null;
    private ExternalContext externalContext = null;

    public LogoutBean() {

    }

    public String doLogout() {
        LOGGER.debug("Logout Called ");
        context = FacesContext.getCurrentInstance();
        externalContext = context.getExternalContext();
        externalContext.getSessionMap().remove("sessonController");
        externalContext.getSessionMap().clear();
        HttpSession session = (HttpSession) externalContext.getSession(true);
        session.invalidate();       
        
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        ec.invalidateSession();
        return "logout";
    }
}
