package io.project.app.patientcare.services;

import io.project.app.patientcare.models.Account;
import io.project.app.patientcare.repositories.AccountRepository;
import io.project.app.patientcare.utils.CommonConstants;
import io.project.app.patientcare.models.LoginRequest;
import io.project.app.patientcare.utils.PasswordHashUtil;
import java.util.Date;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author lilith
 */

@Service
@Slf4j
public class AccountService {
    
    @Autowired
    private AccountRepository accountRepository;
    
    
    
    public Optional<Account> createAccount(Account account){
        log.info("AccountService: creating account");
        
        Optional <Account> findAccountByPhone = accountRepository.findByPhone(account.getPhone());
        
        if(findAccountByPhone.isPresent()){
            log.error("user with that phone number already exists");
            return Optional.empty();
        }
        
        final Account createNewAccount = new Account(account.getPhone(),
                PasswordHashUtil.hashPassword(account.getPassword()),
                account.getFirstname(),
                account.getLastname(),
                account.getAccountType(),
                new Date(System.currentTimeMillis()), CommonConstants.ACTIVATED);
        
        final Account savedAccount = accountRepository.save(createNewAccount);
        
        return Optional.ofNullable(createNewAccount);
    }
    
    public Optional <Account> login(LoginRequest login){
            log.info("user" + login.getPhone());
            
            final Optional <Account> existingUser = accountRepository.findByPhoneAndPassword(login.getPhone(), PasswordHashUtil.hashPassword(login.getPassword()));
            if (!existingUser.isPresent()) {
                log.error("Didn't found user");
                return Optional.empty();
            }            
            
            if(existingUser.isPresent()){
                log.info("User present");
                return Optional.ofNullable(existingUser.get());
            }
            
            return Optional.empty();
        }
}
