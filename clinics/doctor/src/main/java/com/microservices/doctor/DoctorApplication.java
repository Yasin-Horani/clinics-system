package com.microservices.doctor;
import com.microservices.doctor.utilities.EnvLoaderUtility;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class DoctorApplication {
	public static void main(String[] args) {
		EnvLoaderUtility envLoaderUtility = new EnvLoaderUtility();
		envLoaderUtility.loadIntoSystemProperties();
		SpringApplication.run(DoctorApplication.class, args);
	}

}
