package io.project.app.patientcare.repositories;

import io.project.app.models.Account;

import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository

public interface AccountRepository extends MongoRepository<Account, String> {

    Optional<Account> findByEmailAndPassword(String email, String Password);

    Optional<Account> findByPhone(String phone);

    Optional<Account> findByPhoneAndPassword(String phone, String password);

    public void deleteById(Long accountId);
}
