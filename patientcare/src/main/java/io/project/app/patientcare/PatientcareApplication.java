package io.project.app.patientcare;

import io.project.app.patientcare.models.Patient;
import io.project.app.patientcare.services.PatientService;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.event.EventListener;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("io.project.app.patientcare.repositories") 
@ComponentScan(basePackages = {"io.project"})
@EntityScan("io.project.app.patientcare.models")
public class PatientcareApplication {

	public static void main(String[] args) {
		SpringApplication.run(PatientcareApplication.class, args);
	}
        
        @Autowired
        private PatientService patientService;
        
        @EventListener(ApplicationReadyEvent.class) //this works after start of app
        public void populateData(){
            Patient patient = new Patient();
            patient.setActive(true);
            patient.setBirthdate(new Date());
            patient.setFirstname("Emilia");
            patient.setLastname("Clarke");
            patient.setGender("female");
            patient.setHealthStatus("too bad");
            
            patient.setMartialStatus("married");
            patient.setPatientRegisterDate(new Date());
            patient.setPhone("010288888");
            patient.setStatus(1);
            patientService.createPatient(patient);
            
            
            Patient patient2 = new Patient();
            patient.setActive(true);
            patient.setBirthdate(new Date());
            patient.setFirstname("James");
            patient.setLastname("Brown");
            patient.setGender("male");
            patient.setHealthStatus("bad");
            
            patient.setMartialStatus("single");
            patient.setPatientRegisterDate(new Date());
            patient.setPhone("077777777");
            patient.setStatus(1);
            patientService.createPatient(patient2);
        }
        

}
