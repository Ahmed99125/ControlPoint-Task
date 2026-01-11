package com.controlpoint.ottwin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class OtDigitalTwinApplication {

	public static void main(String[] args) {
		SpringApplication.run(OtDigitalTwinApplication.class, args);
	}

}
