/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.project.app.beans.auth;

import io.project.app.dto.AccountDTO;
import io.project.app.unicorn.AuthClient;
import java.io.Serializable;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

/**
 *
 * @author armena
 */
@Named(value = "registerBean")
@ViewScoped
public class RegisterBean implements Serializable{
    
    @Inject
    private AuthClient authClient;
    
    private AccountDTO account = new AccountDTO();

    /**
     * Creates a new instance of RegisterBean
     */
    public RegisterBean() {
    }
    
    
    public String doRegister(){
        System.out.println("Start Register");
        authClient.userRegistration(account);
        
        return "success";
    }

    public AccountDTO getAccount() {
        return account;
    }

    public void setAccount(AccountDTO account) {
        this.account = account;
    }

   
    
    
    
}
