package io.project.app.auth;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;

@Named
@SessionScoped
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
        externalContext.getSessionMap().remove("sessionContext");
        externalContext.getApplicationMap().remove("sessionContext");
        externalContext.getSessionMap().clear();
        HttpSession session = (HttpSession) externalContext.getSession(true);
        session.invalidate();

        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        HttpServletResponse response = (HttpServletResponse) externalContext.getResponse();
        Cookie cookie = new Cookie("JSESSIONID", "");
        cookie.setMaxAge(0);
        cookie.setPath("/");
        response.addCookie(cookie);
        
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        ec.invalidateSession();
        return "logout";
    }
}
