/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.project.app.viewdata;

import io.project.app.dto.AccountDTO;
import io.project.app.unicorn.AuthClient;

import java.io.Serializable;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import sun.util.logging.resources.logging;

/**
 *
 * @author lilith
 */
@Named(value = "viewDataBean")

public class ViewDataBean implements Serializable {

    @Inject
    private AuthClient authClient;

    private AccountDTO account = new AccountDTO();

    public ViewDataBean() {
    }

    public AccountDTO viewAccount() {
        System.out.println("start viewing account");
        AccountDTO viewAcc = authClient.getUserByAccountType(account.getAccountType());
        String type = viewAcc.getAccountType();
        if (type == "Patient") {

            return viewAcc;

        }

        return new AccountDTO();

    }
    
    public AccountDTO getAccount() {
        return account;
    }

    public void setAccount(AccountDTO account) {
        this.account = account;
    }

}
