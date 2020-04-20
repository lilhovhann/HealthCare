package io.project.app.converter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("io.project.app.converter.repositories") 
@ComponentScan(basePackages = {"io.project"})
@EntityScan("io.project.app.converter.models")
public class ConverterApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConverterApplication.class, args);
	}

}
