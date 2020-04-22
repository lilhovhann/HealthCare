package io.project.app.patientcare.controllers;
import io.project.app.patientcare.models.Account;
import io.project.app.patientcare.models.LoginRequest;
import io.project.app.patientcare.models.Patient;
import io.project.app.patientcare.services.AccountService;
import io.project.app.patientcare.services.PatientService;
import java.util.List;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

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
@RequestMapping("/api/v2/registration")
@Slf4j
public class RegAndLoginController {
    
    @Autowired
    private AccountService accountService;
    
    @PostMapping(path = "/registration", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> register(@RequestBody Account account) {
        log.info("Create account");
        
        if(account.getPhone() == null || account.getPassword() == null){
            log.error("Could not create account");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("You must fill phone and password fields");
        }
        
        Optional<Account> savedAccount = accountService.createAccount(account);
        return ResponseEntity.status(HttpStatus.OK).body(savedAccount);
    }
    
//    @PostMapping(path = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<?> login(@RequestBody LoginRequest login) {
//        log.info("Login account");
//        
//        if(login.getPhone() == null || login.getPassword() == null){
//            log.error("Could not login account");
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("You must fill phone and password fields");
//        }
//        
//        Optional<Account> loginnedAccount = accountService.login(login);
//        return ResponseEntity.status(HttpStatus.OK).body(loginnedAccount);
//    }
    

}
