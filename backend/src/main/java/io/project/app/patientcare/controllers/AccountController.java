package io.project.app.patientcare.controllers;

import io.project.app.models.Account;
import io.project.app.models.Login;

import io.project.app.patientcare.services.AccountService;
import java.util.List;

import java.util.Optional;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author lilith
 */
@RestController
@RequestMapping("/api/v2/join")
@Slf4j
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping(path = "/registration", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> register(@RequestBody Account account) {
        log.info("Create account");

        if (account.getPhone() == null || account.getPassword() == null) {
            log.error("Could not create account");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("You must fill phone and password fields");
        }

        Optional<Account> savedAccount = accountService.createAccount(account);
        return ResponseEntity.status(HttpStatus.OK).body(savedAccount.get());
    }

    @PostMapping(path = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> login(@RequestBody Login login) {
        log.info("Login account");

        if (login.getPhone() == null || login.getPassword() == null) {
            log.error("Could not login account");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("You must fill phone and password fields");
        }

        Optional<Account> loginnedAccount = accountService.login(login);

        return ResponseEntity.status(HttpStatus.OK).body(loginnedAccount);
    }

    @PostMapping(path = "/account/update", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> update(@RequestBody Account account) {
        log.info("update account");

        if (account.getId() == null) {
            log.error("Could not create account");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("You must fill account id");
        }

        Account updatedAccount = accountService.updateAccount(account);
        return ResponseEntity.status(HttpStatus.OK).body(updatedAccount);
    }

    @DeleteMapping(path = "/account/id", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> delete(@RequestParam Long id) {
        log.info("delete account");

        if (id == null) {
            log.error("could not delete");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("you must fill account id");
        }

        accountService.removeAccount(id);
        return ResponseEntity.status(HttpStatus.OK).body("Deleted account with id " + id);
    }

    @GetMapping(path = "/account", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findAll() {
        List<Account> findAllSavedAccounts = accountService.findAllSavedAccounts();
        return ResponseEntity.status(HttpStatus.OK).body(findAllSavedAccounts);
    }

}
