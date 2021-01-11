package com.alvesjefs.mscomputers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ECommerceMsComputersApplication {

	public static void main(String[] args) {
		SpringApplication.run(ECommerceMsComputersApplication.class, args);
	}

}
