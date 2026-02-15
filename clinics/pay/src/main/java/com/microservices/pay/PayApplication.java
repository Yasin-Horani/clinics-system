package com.microservices.pay;

import com.microservices.pay.utilities.EnvLoaderUtility;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PayApplication {

	public static void main(String[] args) {

		EnvLoaderUtility envLoaderUtility = new EnvLoaderUtility();
		envLoaderUtility.loadIntoSystemProperties();
		SpringApplication.run(PayApplication.class, args);
	}

}
