package io.project.app.patientcare.repositories;

import io.project.app.patientcare.models.Account;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface AccountRepository  extends CrudRepository<Account, String>{
    Optional <Account> findByEmailAndPassword(String email, String Password);
    Optional <Account> findByPhone(String phone);
    Optional <Account> findByPhoneAndPassword(String phone, String password);
    Optional <List<Account>> findAllByAccountType (String accountType);
}   
