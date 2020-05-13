package io.project.app.patientcare.services;

import io.project.app.patientcare.models.Account;
import io.project.app.patientcare.repositories.AccountRepository;
import io.project.app.patientcare.utils.CommonConstants;
import io.project.app.patientcare.models.Login;
import io.project.app.patientcare.models.Patient;
import io.project.app.patientcare.repositories.PatientRepository;
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
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public Optional<Patient> createPatient(Patient patient) {
        log.info("AccountService: creating account");

        Optional<Patient> findById = patientRepository.findById(patient.getId());

        if (findById.isPresent()) {
            log.error("patient with that id  already exists");
            return Optional.empty();
        }

        final Patient createNewPatient = new Patient(
                patient.getId(),
                patient.getFirstname(),
                patient.getLastname(),
                patient.getPhone(),
                patient.getEmail(),
                patient.getMiddlename(),
                new Date(System.currentTimeMillis())
        );

        final Patient savedPatient = patientRepository.save(createNewPatient);

        return Optional.ofNullable(createNewPatient);
    }

    public Patient updatePatient(Patient patient) {
        log.info("Creating Patient");
        if (patient.getId() == null) {
            log.error("provide patient id for update");
            return new Patient();
        }
        log.info("Update patient with id " + patient.getId());
        Patient updatedPatient = patientRepository.save(patient);
        return updatedPatient;
    }

    public void removePatient(String patientId) {
        log.info("find patient with id and delete");
        patientRepository.deleteById(patientId);
    }

    public List<Patient> findAllSavedPatients() {
        log.info("find all patients, return Array List or List");
        return (List<Patient>) patientRepository.findAll();
    }
}
