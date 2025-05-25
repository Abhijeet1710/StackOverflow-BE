package com.StackOverflow.UploaderService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class UploaderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UploaderServiceApplication.class, args);
	}

}
