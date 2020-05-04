/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.project.app.beans.auth;

import io.project.app.api.requests.LoginRequest;
import io.project.app.dto.AccountDTO;
import io.project.app.unicorn.AuthClient;
import io.project.app.usercontext.SessonController;
import java.io.Serializable;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

/**
 *
 * @author armena
 */
@Named(value = "loginBean")
@ViewScoped
public class LoginBean implements Serializable {

    @Inject
    private AuthClient authClient;

    private LoginRequest loginRequest = new LoginRequest();

    @Inject
    private SessonController sessonController;

    /**
     * Creates a new instance of RegisterBean
     */
    public LoginBean() {
    }

    public String doLogin() {
        System.out.println("Start login");
        AccountDTO userLogin = authClient.userLogin(loginRequest);
        if (userLogin.getId() != null) {
            sessonController.setAccount(userLogin);
            return "profile";
        }

        return "error";
    }

    public LoginRequest getLoginRequest() {
        return loginRequest;
    }

    public void setLoginRequest(LoginRequest loginRequest) {
        this.loginRequest = loginRequest;
    }

}
