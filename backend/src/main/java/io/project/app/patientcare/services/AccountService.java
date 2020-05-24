package io.project.app.patientcare.services;

import io.project.app.models.Account;
import io.project.app.patientcare.repositories.AccountRepository;
import io.project.app.patientcare.utils.CommonConstants;
import io.project.app.models.Login;
import io.project.app.patientcare.utils.PasswordHashUtil;
import java.util.Date;
import java.util.List;
import java.util.Optional;
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

    public Optional<Account> createAccount(Account account) {
        log.info("AccountService: creating account");

        Optional<Account> findAccountByPhone = accountRepository.findByPhone(account.getPhone());

        if (findAccountByPhone.isPresent()) {
            log.error("user with that phone number already exists");
            return Optional.empty();
        }

        final Account createNewAccount = new Account(
                account.getFirstname(),
                account.getLastname(),
                account.getMiddlename(),
                account.getPhone(),
                account.getEmail(),
                PasswordHashUtil.hashPassword(account.getPassword()),
                new Date(System.currentTimeMillis()));

        final Account savedAccount = accountRepository.save(createNewAccount);

        return Optional.ofNullable(createNewAccount);
    }

    public Optional<Account> login(Login login) {
        log.info("user" + login.getPhone());

        final Optional<Account> existingUser = accountRepository.findByPhoneAndPassword(login.getPhone(), PasswordHashUtil.hashPassword(login.getPassword()));
        if (!existingUser.isPresent()) {
            log.error("Didn't found user");
            return Optional.empty();
        }

        if (existingUser.isPresent()) {
            log.info("User present");
            return Optional.ofNullable(existingUser.get());
        }

        return Optional.empty();
    }

    public Account updateAccount(Account account) {
        log.info("Creating Patient");
        if (account.getId() == null) {
            log.error("provide patient id for update");
            return new Account();
        }
        log.info("Update patient with id " + account.getId());
        Account updatedAccount = accountRepository.save(account);
        return updatedAccount;
    }

    public void removeAccount(Long accountId) {
        log.info("find patient with id and delete");
        accountRepository.deleteById(accountId);
    }

    public List<Account> findAllSavedAccounts() {
        log.info("find all patients, return Array List or List");
        return (List<Account>) accountRepository.findAll();
    }
}
