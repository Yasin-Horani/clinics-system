package com.microservices.patient;

import com.microservices.patient.utilities.EnvLoaderUtility;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PatientApplication {

	public static void main(String[] args) {
		EnvLoaderUtility envLoaderUtility = new EnvLoaderUtility();
		envLoaderUtility.loadIntoSystemProperties();
		SpringApplication.run(PatientApplication.class, args);
	}
}
