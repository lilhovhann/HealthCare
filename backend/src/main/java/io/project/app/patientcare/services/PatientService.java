package io.project.app.patientcare.services;

import io.project.app.patientcare.models.Patient;
import io.project.app.patientcare.repositories.PatientRepository;
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
        patient.setId(null);
        log.info("always new");

        final Patient savedPatient = patientRepository.save(patient);

        return Optional.ofNullable(savedPatient);
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
        return patientRepository.findAll();
    }
}
