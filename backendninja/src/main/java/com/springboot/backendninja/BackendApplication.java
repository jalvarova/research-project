package com.springboot.backendninja;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableJpaRepositories(basePackages={"com.springboot.backendninja.repository"})
//@EntityScan(basePackages={"com.springboot.backendninja.entity"})
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}
}
