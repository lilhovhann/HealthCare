package io.project.app.patientcare;

import io.project.app.patientcare.models.Account;
import io.project.app.patientcare.services.AccountService;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.event.EventListener;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


@SpringBootApplication
@EnableMongoRepositories("io.project.app.patientcare.repositories") 
@ComponentScan(basePackages = {"io.project"})
@EntityScan("io.project.app.patientcare.models")
public class PatientcareApplication {

	public static void main(String[] args) {
	
                final SpringApplication application = new SpringApplication(PatientcareApplication.class);
                application.setBannerMode(Banner.Mode.OFF);
//              
                application.run(args);
	}
        
       
        

}
