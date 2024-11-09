package com.cloud.spin.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class CloudSpinServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudSpinServiceApplication.class, args);
	}

}
